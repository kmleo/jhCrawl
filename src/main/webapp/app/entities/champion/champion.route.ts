import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IChampion, Champion } from 'app/shared/model/champion.model';
import { ChampionService } from './champion.service';
import { ChampionComponent } from './champion.component';
import { ChampionDetailComponent } from './champion-detail.component';
import { ChampionUpdateComponent } from './champion-update.component';

@Injectable({ providedIn: 'root' })
export class ChampionResolve implements Resolve<IChampion> {
  constructor(private service: ChampionService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IChampion> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((champion: HttpResponse<Champion>) => {
          if (champion.body) {
            return of(champion.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new Champion());
  }
}

export const championRoute: Routes = [
  {
    path: '',
    component: ChampionComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'Champions'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: ChampionDetailComponent,
    resolve: {
      champion: ChampionResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'Champions'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: ChampionUpdateComponent,
    resolve: {
      champion: ChampionResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'Champions'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: ChampionUpdateComponent,
    resolve: {
      champion: ChampionResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'Champions'
    },
    canActivate: [UserRouteAccessService]
  }
];

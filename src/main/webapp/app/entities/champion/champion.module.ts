import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhCrawlSharedModule } from 'app/shared/shared.module';
import { ChampionComponent } from './champion.component';
import { ChampionDetailComponent } from './champion-detail.component';
import { ChampionUpdateComponent } from './champion-update.component';
import { ChampionDeleteDialogComponent } from './champion-delete-dialog.component';
import { championRoute } from './champion.route';

@NgModule({
  imports: [JhCrawlSharedModule, RouterModule.forChild(championRoute)],
  declarations: [ChampionComponent, ChampionDetailComponent, ChampionUpdateComponent, ChampionDeleteDialogComponent],
  entryComponents: [ChampionDeleteDialogComponent]
})
export class JhCrawlChampionModule {}

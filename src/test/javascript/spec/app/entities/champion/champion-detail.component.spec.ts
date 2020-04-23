import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { JhCrawlTestModule } from '../../../test.module';
import { ChampionDetailComponent } from 'app/entities/champion/champion-detail.component';
import { Champion } from 'app/shared/model/champion.model';

describe('Component Tests', () => {
  describe('Champion Management Detail Component', () => {
    let comp: ChampionDetailComponent;
    let fixture: ComponentFixture<ChampionDetailComponent>;
    const route = ({ data: of({ champion: new Champion(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhCrawlTestModule],
        declarations: [ChampionDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(ChampionDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(ChampionDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load champion on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.champion).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});

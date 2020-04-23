import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IChampion } from 'app/shared/model/champion.model';

@Component({
  selector: 'jhi-champion-detail',
  templateUrl: './champion-detail.component.html'
})
export class ChampionDetailComponent implements OnInit {
  champion: IChampion | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ champion }) => (this.champion = champion));
  }

  previousState(): void {
    window.history.back();
  }
}

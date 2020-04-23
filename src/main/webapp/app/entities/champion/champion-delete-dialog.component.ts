import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IChampion } from 'app/shared/model/champion.model';
import { ChampionService } from './champion.service';

@Component({
  templateUrl: './champion-delete-dialog.component.html'
})
export class ChampionDeleteDialogComponent {
  champion?: IChampion;

  constructor(protected championService: ChampionService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.championService.delete(id).subscribe(() => {
      this.eventManager.broadcast('championListModification');
      this.activeModal.close();
    });
  }
}

import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IChampion, Champion } from 'app/shared/model/champion.model';
import { ChampionService } from './champion.service';

@Component({
  selector: 'jhi-champion-update',
  templateUrl: './champion-update.component.html'
})
export class ChampionUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    name: [null, [Validators.required]],
    faction: [],
    rarity: [],
    affinity: [],
    role: [],
    rank: [],
    viewPageUrl: [],
    fusion: [],
    equipmentA: [],
    equipmentB: [],
    equipmentStatPriorityA: [],
    equipmentStatPriorityB: [],
    tier: [],
    healthPoints: [],
    attack: [],
    defense: [],
    speed: [],
    criticalRate: [],
    criticalDamage: [],
    resistance: [],
    accuracy: [],
    campaignRating: [],
    factionWarRating: [],
    arenaOffenseRating: [],
    arenaDefenseRating: [],
    iceGolemRating: [],
    spidersDenRating: [],
    minotaursLabyrinthRating: [],
    dragonsLairRating: [],
    fireKnightsCastleRating: [],
    voidKeepRating: [],
    spiritKeepRating: [],
    magicKeepRating: [],
    forceKeepRating: []
  });

  constructor(protected championService: ChampionService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ champion }) => {
      this.updateForm(champion);
    });
  }

  updateForm(champion: IChampion): void {
    this.editForm.patchValue({
      id: champion.id,
      name: champion.name,
      faction: champion.faction,
      rarity: champion.rarity,
      affinity: champion.affinity,
      role: champion.role,
      rank: champion.rank,
      viewPageUrl: champion.viewPageUrl,
      fusion: champion.fusion,
      equipmentA: champion.equipmentA,
      equipmentB: champion.equipmentB,
      equipmentStatPriorityA: champion.equipmentStatPriorityA,
      equipmentStatPriorityB: champion.equipmentStatPriorityB,
      tier: champion.tier,
      healthPoints: champion.healthPoints,
      attack: champion.attack,
      defense: champion.defense,
      speed: champion.speed,
      criticalRate: champion.criticalRate,
      criticalDamage: champion.criticalDamage,
      resistance: champion.resistance,
      accuracy: champion.accuracy,
      campaignRating: champion.campaignRating,
      factionWarRating: champion.factionWarRating,
      arenaOffenseRating: champion.arenaOffenseRating,
      arenaDefenseRating: champion.arenaDefenseRating,
      iceGolemRating: champion.iceGolemRating,
      spidersDenRating: champion.spidersDenRating,
      minotaursLabyrinthRating: champion.minotaursLabyrinthRating,
      dragonsLairRating: champion.dragonsLairRating,
      fireKnightsCastleRating: champion.fireKnightsCastleRating,
      voidKeepRating: champion.voidKeepRating,
      spiritKeepRating: champion.spiritKeepRating,
      magicKeepRating: champion.magicKeepRating,
      forceKeepRating: champion.forceKeepRating
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const champion = this.createFromForm();
    if (champion.id !== undefined) {
      this.subscribeToSaveResponse(this.championService.update(champion));
    } else {
      this.subscribeToSaveResponse(this.championService.create(champion));
    }
  }

  private createFromForm(): IChampion {
    return {
      ...new Champion(),
      id: this.editForm.get(['id'])!.value,
      name: this.editForm.get(['name'])!.value,
      faction: this.editForm.get(['faction'])!.value,
      rarity: this.editForm.get(['rarity'])!.value,
      affinity: this.editForm.get(['affinity'])!.value,
      role: this.editForm.get(['role'])!.value,
      rank: this.editForm.get(['rank'])!.value,
      viewPageUrl: this.editForm.get(['viewPageUrl'])!.value,
      fusion: this.editForm.get(['fusion'])!.value,
      equipmentA: this.editForm.get(['equipmentA'])!.value,
      equipmentB: this.editForm.get(['equipmentB'])!.value,
      equipmentStatPriorityA: this.editForm.get(['equipmentStatPriorityA'])!.value,
      equipmentStatPriorityB: this.editForm.get(['equipmentStatPriorityB'])!.value,
      tier: this.editForm.get(['tier'])!.value,
      healthPoints: this.editForm.get(['healthPoints'])!.value,
      attack: this.editForm.get(['attack'])!.value,
      defense: this.editForm.get(['defense'])!.value,
      speed: this.editForm.get(['speed'])!.value,
      criticalRate: this.editForm.get(['criticalRate'])!.value,
      criticalDamage: this.editForm.get(['criticalDamage'])!.value,
      resistance: this.editForm.get(['resistance'])!.value,
      accuracy: this.editForm.get(['accuracy'])!.value,
      campaignRating: this.editForm.get(['campaignRating'])!.value,
      factionWarRating: this.editForm.get(['factionWarRating'])!.value,
      arenaOffenseRating: this.editForm.get(['arenaOffenseRating'])!.value,
      arenaDefenseRating: this.editForm.get(['arenaDefenseRating'])!.value,
      iceGolemRating: this.editForm.get(['iceGolemRating'])!.value,
      spidersDenRating: this.editForm.get(['spidersDenRating'])!.value,
      minotaursLabyrinthRating: this.editForm.get(['minotaursLabyrinthRating'])!.value,
      dragonsLairRating: this.editForm.get(['dragonsLairRating'])!.value,
      fireKnightsCastleRating: this.editForm.get(['fireKnightsCastleRating'])!.value,
      voidKeepRating: this.editForm.get(['voidKeepRating'])!.value,
      spiritKeepRating: this.editForm.get(['spiritKeepRating'])!.value,
      magicKeepRating: this.editForm.get(['magicKeepRating'])!.value,
      forceKeepRating: this.editForm.get(['forceKeepRating'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IChampion>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }
}

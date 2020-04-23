import { element, by, ElementFinder } from 'protractor';

export class ChampionComponentsPage {
  createButton = element(by.id('jh-create-entity'));
  deleteButtons = element.all(by.css('jhi-champion div table .btn-danger'));
  title = element.all(by.css('jhi-champion div h2#page-heading span')).first();
  noResult = element(by.id('no-result'));
  entities = element(by.id('entities'));

  async clickOnCreateButton(): Promise<void> {
    await this.createButton.click();
  }

  async clickOnLastDeleteButton(): Promise<void> {
    await this.deleteButtons.last().click();
  }

  async countDeleteButtons(): Promise<number> {
    return this.deleteButtons.count();
  }

  async getTitle(): Promise<string> {
    return this.title.getText();
  }
}

export class ChampionUpdatePage {
  pageTitle = element(by.id('jhi-champion-heading'));
  saveButton = element(by.id('save-entity'));
  cancelButton = element(by.id('cancel-save'));

  nameInput = element(by.id('field_name'));
  factionInput = element(by.id('field_faction'));
  rarityInput = element(by.id('field_rarity'));
  affinityInput = element(by.id('field_affinity'));
  roleInput = element(by.id('field_role'));
  rankInput = element(by.id('field_rank'));
  viewPageUrlInput = element(by.id('field_viewPageUrl'));
  fusionInput = element(by.id('field_fusion'));
  equipmentAInput = element(by.id('field_equipmentA'));
  equipmentBInput = element(by.id('field_equipmentB'));
  equipmentStatPriorityAInput = element(by.id('field_equipmentStatPriorityA'));
  equipmentStatPriorityBInput = element(by.id('field_equipmentStatPriorityB'));
  tierInput = element(by.id('field_tier'));
  healthPointsInput = element(by.id('field_healthPoints'));
  attackInput = element(by.id('field_attack'));
  defenseInput = element(by.id('field_defense'));
  speedInput = element(by.id('field_speed'));
  criticalRateInput = element(by.id('field_criticalRate'));
  criticalDamageInput = element(by.id('field_criticalDamage'));
  resistanceInput = element(by.id('field_resistance'));
  accuracyInput = element(by.id('field_accuracy'));
  campaignRatingInput = element(by.id('field_campaignRating'));
  factionWarRatingInput = element(by.id('field_factionWarRating'));
  arenaOffenseRatingInput = element(by.id('field_arenaOffenseRating'));
  arenaDefenseRatingInput = element(by.id('field_arenaDefenseRating'));
  iceGolemRatingInput = element(by.id('field_iceGolemRating'));
  spidersDenRatingInput = element(by.id('field_spidersDenRating'));
  minotaursLabyrinthRatingInput = element(by.id('field_minotaursLabyrinthRating'));
  dragonsLairRatingInput = element(by.id('field_dragonsLairRating'));
  fireKnightsCastleRatingInput = element(by.id('field_fireKnightsCastleRating'));
  voidKeepRatingInput = element(by.id('field_voidKeepRating'));
  spiritKeepRatingInput = element(by.id('field_spiritKeepRating'));
  magicKeepRatingInput = element(by.id('field_magicKeepRating'));
  forceKeepRatingInput = element(by.id('field_forceKeepRating'));

  async getPageTitle(): Promise<string> {
    return this.pageTitle.getText();
  }

  async setNameInput(name: string): Promise<void> {
    await this.nameInput.sendKeys(name);
  }

  async getNameInput(): Promise<string> {
    return await this.nameInput.getAttribute('value');
  }

  async setFactionInput(faction: string): Promise<void> {
    await this.factionInput.sendKeys(faction);
  }

  async getFactionInput(): Promise<string> {
    return await this.factionInput.getAttribute('value');
  }

  async setRarityInput(rarity: string): Promise<void> {
    await this.rarityInput.sendKeys(rarity);
  }

  async getRarityInput(): Promise<string> {
    return await this.rarityInput.getAttribute('value');
  }

  async setAffinityInput(affinity: string): Promise<void> {
    await this.affinityInput.sendKeys(affinity);
  }

  async getAffinityInput(): Promise<string> {
    return await this.affinityInput.getAttribute('value');
  }

  async setRoleInput(role: string): Promise<void> {
    await this.roleInput.sendKeys(role);
  }

  async getRoleInput(): Promise<string> {
    return await this.roleInput.getAttribute('value');
  }

  async setRankInput(rank: string): Promise<void> {
    await this.rankInput.sendKeys(rank);
  }

  async getRankInput(): Promise<string> {
    return await this.rankInput.getAttribute('value');
  }

  async setViewPageUrlInput(viewPageUrl: string): Promise<void> {
    await this.viewPageUrlInput.sendKeys(viewPageUrl);
  }

  async getViewPageUrlInput(): Promise<string> {
    return await this.viewPageUrlInput.getAttribute('value');
  }

  async setFusionInput(fusion: string): Promise<void> {
    await this.fusionInput.sendKeys(fusion);
  }

  async getFusionInput(): Promise<string> {
    return await this.fusionInput.getAttribute('value');
  }

  async setEquipmentAInput(equipmentA: string): Promise<void> {
    await this.equipmentAInput.sendKeys(equipmentA);
  }

  async getEquipmentAInput(): Promise<string> {
    return await this.equipmentAInput.getAttribute('value');
  }

  async setEquipmentBInput(equipmentB: string): Promise<void> {
    await this.equipmentBInput.sendKeys(equipmentB);
  }

  async getEquipmentBInput(): Promise<string> {
    return await this.equipmentBInput.getAttribute('value');
  }

  async setEquipmentStatPriorityAInput(equipmentStatPriorityA: string): Promise<void> {
    await this.equipmentStatPriorityAInput.sendKeys(equipmentStatPriorityA);
  }

  async getEquipmentStatPriorityAInput(): Promise<string> {
    return await this.equipmentStatPriorityAInput.getAttribute('value');
  }

  async setEquipmentStatPriorityBInput(equipmentStatPriorityB: string): Promise<void> {
    await this.equipmentStatPriorityBInput.sendKeys(equipmentStatPriorityB);
  }

  async getEquipmentStatPriorityBInput(): Promise<string> {
    return await this.equipmentStatPriorityBInput.getAttribute('value');
  }

  async setTierInput(tier: string): Promise<void> {
    await this.tierInput.sendKeys(tier);
  }

  async getTierInput(): Promise<string> {
    return await this.tierInput.getAttribute('value');
  }

  async setHealthPointsInput(healthPoints: string): Promise<void> {
    await this.healthPointsInput.sendKeys(healthPoints);
  }

  async getHealthPointsInput(): Promise<string> {
    return await this.healthPointsInput.getAttribute('value');
  }

  async setAttackInput(attack: string): Promise<void> {
    await this.attackInput.sendKeys(attack);
  }

  async getAttackInput(): Promise<string> {
    return await this.attackInput.getAttribute('value');
  }

  async setDefenseInput(defense: string): Promise<void> {
    await this.defenseInput.sendKeys(defense);
  }

  async getDefenseInput(): Promise<string> {
    return await this.defenseInput.getAttribute('value');
  }

  async setSpeedInput(speed: string): Promise<void> {
    await this.speedInput.sendKeys(speed);
  }

  async getSpeedInput(): Promise<string> {
    return await this.speedInput.getAttribute('value');
  }

  async setCriticalRateInput(criticalRate: string): Promise<void> {
    await this.criticalRateInput.sendKeys(criticalRate);
  }

  async getCriticalRateInput(): Promise<string> {
    return await this.criticalRateInput.getAttribute('value');
  }

  async setCriticalDamageInput(criticalDamage: string): Promise<void> {
    await this.criticalDamageInput.sendKeys(criticalDamage);
  }

  async getCriticalDamageInput(): Promise<string> {
    return await this.criticalDamageInput.getAttribute('value');
  }

  async setResistanceInput(resistance: string): Promise<void> {
    await this.resistanceInput.sendKeys(resistance);
  }

  async getResistanceInput(): Promise<string> {
    return await this.resistanceInput.getAttribute('value');
  }

  async setAccuracyInput(accuracy: string): Promise<void> {
    await this.accuracyInput.sendKeys(accuracy);
  }

  async getAccuracyInput(): Promise<string> {
    return await this.accuracyInput.getAttribute('value');
  }

  async setCampaignRatingInput(campaignRating: string): Promise<void> {
    await this.campaignRatingInput.sendKeys(campaignRating);
  }

  async getCampaignRatingInput(): Promise<string> {
    return await this.campaignRatingInput.getAttribute('value');
  }

  async setFactionWarRatingInput(factionWarRating: string): Promise<void> {
    await this.factionWarRatingInput.sendKeys(factionWarRating);
  }

  async getFactionWarRatingInput(): Promise<string> {
    return await this.factionWarRatingInput.getAttribute('value');
  }

  async setArenaOffenseRatingInput(arenaOffenseRating: string): Promise<void> {
    await this.arenaOffenseRatingInput.sendKeys(arenaOffenseRating);
  }

  async getArenaOffenseRatingInput(): Promise<string> {
    return await this.arenaOffenseRatingInput.getAttribute('value');
  }

  async setArenaDefenseRatingInput(arenaDefenseRating: string): Promise<void> {
    await this.arenaDefenseRatingInput.sendKeys(arenaDefenseRating);
  }

  async getArenaDefenseRatingInput(): Promise<string> {
    return await this.arenaDefenseRatingInput.getAttribute('value');
  }

  async setIceGolemRatingInput(iceGolemRating: string): Promise<void> {
    await this.iceGolemRatingInput.sendKeys(iceGolemRating);
  }

  async getIceGolemRatingInput(): Promise<string> {
    return await this.iceGolemRatingInput.getAttribute('value');
  }

  async setSpidersDenRatingInput(spidersDenRating: string): Promise<void> {
    await this.spidersDenRatingInput.sendKeys(spidersDenRating);
  }

  async getSpidersDenRatingInput(): Promise<string> {
    return await this.spidersDenRatingInput.getAttribute('value');
  }

  async setMinotaursLabyrinthRatingInput(minotaursLabyrinthRating: string): Promise<void> {
    await this.minotaursLabyrinthRatingInput.sendKeys(minotaursLabyrinthRating);
  }

  async getMinotaursLabyrinthRatingInput(): Promise<string> {
    return await this.minotaursLabyrinthRatingInput.getAttribute('value');
  }

  async setDragonsLairRatingInput(dragonsLairRating: string): Promise<void> {
    await this.dragonsLairRatingInput.sendKeys(dragonsLairRating);
  }

  async getDragonsLairRatingInput(): Promise<string> {
    return await this.dragonsLairRatingInput.getAttribute('value');
  }

  async setFireKnightsCastleRatingInput(fireKnightsCastleRating: string): Promise<void> {
    await this.fireKnightsCastleRatingInput.sendKeys(fireKnightsCastleRating);
  }

  async getFireKnightsCastleRatingInput(): Promise<string> {
    return await this.fireKnightsCastleRatingInput.getAttribute('value');
  }

  async setVoidKeepRatingInput(voidKeepRating: string): Promise<void> {
    await this.voidKeepRatingInput.sendKeys(voidKeepRating);
  }

  async getVoidKeepRatingInput(): Promise<string> {
    return await this.voidKeepRatingInput.getAttribute('value');
  }

  async setSpiritKeepRatingInput(spiritKeepRating: string): Promise<void> {
    await this.spiritKeepRatingInput.sendKeys(spiritKeepRating);
  }

  async getSpiritKeepRatingInput(): Promise<string> {
    return await this.spiritKeepRatingInput.getAttribute('value');
  }

  async setMagicKeepRatingInput(magicKeepRating: string): Promise<void> {
    await this.magicKeepRatingInput.sendKeys(magicKeepRating);
  }

  async getMagicKeepRatingInput(): Promise<string> {
    return await this.magicKeepRatingInput.getAttribute('value');
  }

  async setForceKeepRatingInput(forceKeepRating: string): Promise<void> {
    await this.forceKeepRatingInput.sendKeys(forceKeepRating);
  }

  async getForceKeepRatingInput(): Promise<string> {
    return await this.forceKeepRatingInput.getAttribute('value');
  }

  async save(): Promise<void> {
    await this.saveButton.click();
  }

  async cancel(): Promise<void> {
    await this.cancelButton.click();
  }

  getSaveButton(): ElementFinder {
    return this.saveButton;
  }
}

export class ChampionDeleteDialog {
  private dialogTitle = element(by.id('jhi-delete-champion-heading'));
  private confirmButton = element(by.id('jhi-confirm-delete-champion'));

  async getDialogTitle(): Promise<string> {
    return this.dialogTitle.getText();
  }

  async clickOnConfirmButton(): Promise<void> {
    await this.confirmButton.click();
  }
}

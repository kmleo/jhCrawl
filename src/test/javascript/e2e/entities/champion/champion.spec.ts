import { browser, ExpectedConditions as ec, promise } from 'protractor';
import { NavBarPage, SignInPage } from '../../page-objects/jhi-page-objects';

import { ChampionComponentsPage, ChampionDeleteDialog, ChampionUpdatePage } from './champion.page-object';

const expect = chai.expect;

describe('Champion e2e test', () => {
  let navBarPage: NavBarPage;
  let signInPage: SignInPage;
  let championComponentsPage: ChampionComponentsPage;
  let championUpdatePage: ChampionUpdatePage;
  let championDeleteDialog: ChampionDeleteDialog;

  before(async () => {
    await browser.get('/');
    navBarPage = new NavBarPage();
    signInPage = await navBarPage.getSignInPage();
    await signInPage.autoSignInUsing('admin', 'admin');
    await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
  });

  it('should load Champions', async () => {
    await navBarPage.goToEntity('champion');
    championComponentsPage = new ChampionComponentsPage();
    await browser.wait(ec.visibilityOf(championComponentsPage.title), 5000);
    expect(await championComponentsPage.getTitle()).to.eq('Champions');
    await browser.wait(ec.or(ec.visibilityOf(championComponentsPage.entities), ec.visibilityOf(championComponentsPage.noResult)), 1000);
  });

  it('should load create Champion page', async () => {
    await championComponentsPage.clickOnCreateButton();
    championUpdatePage = new ChampionUpdatePage();
    expect(await championUpdatePage.getPageTitle()).to.eq('Create or edit a Champion');
    await championUpdatePage.cancel();
  });

  it('should create and save Champions', async () => {
    const nbButtonsBeforeCreate = await championComponentsPage.countDeleteButtons();

    await championComponentsPage.clickOnCreateButton();

    await promise.all([
      championUpdatePage.setNameInput('name'),
      championUpdatePage.setFactionInput('faction'),
      championUpdatePage.setRarityInput('rarity'),
      championUpdatePage.setAffinityInput('affinity'),
      championUpdatePage.setRoleInput('role'),
      championUpdatePage.setRankInput('rank'),
      championUpdatePage.setViewPageUrlInput('viewPageUrl'),
      championUpdatePage.setFusionInput('fusion'),
      championUpdatePage.setEquipmentAInput('equipmentA'),
      championUpdatePage.setEquipmentBInput('equipmentB'),
      championUpdatePage.setEquipmentStatPriorityAInput('equipmentStatPriorityA'),
      championUpdatePage.setEquipmentStatPriorityBInput('equipmentStatPriorityB'),
      championUpdatePage.setTierInput('5'),
      championUpdatePage.setHealthPointsInput('5'),
      championUpdatePage.setAttackInput('5'),
      championUpdatePage.setDefenseInput('5'),
      championUpdatePage.setSpeedInput('5'),
      championUpdatePage.setCriticalRateInput('5'),
      championUpdatePage.setCriticalDamageInput('5'),
      championUpdatePage.setResistanceInput('5'),
      championUpdatePage.setAccuracyInput('5'),
      championUpdatePage.setCampaignRatingInput('5'),
      championUpdatePage.setFactionWarRatingInput('5'),
      championUpdatePage.setArenaOffenseRatingInput('5'),
      championUpdatePage.setArenaDefenseRatingInput('5'),
      championUpdatePage.setIceGolemRatingInput('5'),
      championUpdatePage.setSpidersDenRatingInput('5'),
      championUpdatePage.setMinotaursLabyrinthRatingInput('5'),
      championUpdatePage.setDragonsLairRatingInput('5'),
      championUpdatePage.setFireKnightsCastleRatingInput('5'),
      championUpdatePage.setVoidKeepRatingInput('5'),
      championUpdatePage.setSpiritKeepRatingInput('5'),
      championUpdatePage.setMagicKeepRatingInput('5'),
      championUpdatePage.setForceKeepRatingInput('5')
    ]);

    expect(await championUpdatePage.getNameInput()).to.eq('name', 'Expected Name value to be equals to name');
    expect(await championUpdatePage.getFactionInput()).to.eq('faction', 'Expected Faction value to be equals to faction');
    expect(await championUpdatePage.getRarityInput()).to.eq('rarity', 'Expected Rarity value to be equals to rarity');
    expect(await championUpdatePage.getAffinityInput()).to.eq('affinity', 'Expected Affinity value to be equals to affinity');
    expect(await championUpdatePage.getRoleInput()).to.eq('role', 'Expected Role value to be equals to role');
    expect(await championUpdatePage.getRankInput()).to.eq('rank', 'Expected Rank value to be equals to rank');
    expect(await championUpdatePage.getViewPageUrlInput()).to.eq('viewPageUrl', 'Expected ViewPageUrl value to be equals to viewPageUrl');
    expect(await championUpdatePage.getFusionInput()).to.eq('fusion', 'Expected Fusion value to be equals to fusion');
    expect(await championUpdatePage.getEquipmentAInput()).to.eq('equipmentA', 'Expected EquipmentA value to be equals to equipmentA');
    expect(await championUpdatePage.getEquipmentBInput()).to.eq('equipmentB', 'Expected EquipmentB value to be equals to equipmentB');
    expect(await championUpdatePage.getEquipmentStatPriorityAInput()).to.eq(
      'equipmentStatPriorityA',
      'Expected EquipmentStatPriorityA value to be equals to equipmentStatPriorityA'
    );
    expect(await championUpdatePage.getEquipmentStatPriorityBInput()).to.eq(
      'equipmentStatPriorityB',
      'Expected EquipmentStatPriorityB value to be equals to equipmentStatPriorityB'
    );
    expect(await championUpdatePage.getTierInput()).to.eq('5', 'Expected tier value to be equals to 5');
    expect(await championUpdatePage.getHealthPointsInput()).to.eq('5', 'Expected healthPoints value to be equals to 5');
    expect(await championUpdatePage.getAttackInput()).to.eq('5', 'Expected attack value to be equals to 5');
    expect(await championUpdatePage.getDefenseInput()).to.eq('5', 'Expected defense value to be equals to 5');
    expect(await championUpdatePage.getSpeedInput()).to.eq('5', 'Expected speed value to be equals to 5');
    expect(await championUpdatePage.getCriticalRateInput()).to.eq('5', 'Expected criticalRate value to be equals to 5');
    expect(await championUpdatePage.getCriticalDamageInput()).to.eq('5', 'Expected criticalDamage value to be equals to 5');
    expect(await championUpdatePage.getResistanceInput()).to.eq('5', 'Expected resistance value to be equals to 5');
    expect(await championUpdatePage.getAccuracyInput()).to.eq('5', 'Expected accuracy value to be equals to 5');
    expect(await championUpdatePage.getCampaignRatingInput()).to.eq('5', 'Expected campaignRating value to be equals to 5');
    expect(await championUpdatePage.getFactionWarRatingInput()).to.eq('5', 'Expected factionWarRating value to be equals to 5');
    expect(await championUpdatePage.getArenaOffenseRatingInput()).to.eq('5', 'Expected arenaOffenseRating value to be equals to 5');
    expect(await championUpdatePage.getArenaDefenseRatingInput()).to.eq('5', 'Expected arenaDefenseRating value to be equals to 5');
    expect(await championUpdatePage.getIceGolemRatingInput()).to.eq('5', 'Expected iceGolemRating value to be equals to 5');
    expect(await championUpdatePage.getSpidersDenRatingInput()).to.eq('5', 'Expected spidersDenRating value to be equals to 5');
    expect(await championUpdatePage.getMinotaursLabyrinthRatingInput()).to.eq(
      '5',
      'Expected minotaursLabyrinthRating value to be equals to 5'
    );
    expect(await championUpdatePage.getDragonsLairRatingInput()).to.eq('5', 'Expected dragonsLairRating value to be equals to 5');
    expect(await championUpdatePage.getFireKnightsCastleRatingInput()).to.eq(
      '5',
      'Expected fireKnightsCastleRating value to be equals to 5'
    );
    expect(await championUpdatePage.getVoidKeepRatingInput()).to.eq('5', 'Expected voidKeepRating value to be equals to 5');
    expect(await championUpdatePage.getSpiritKeepRatingInput()).to.eq('5', 'Expected spiritKeepRating value to be equals to 5');
    expect(await championUpdatePage.getMagicKeepRatingInput()).to.eq('5', 'Expected magicKeepRating value to be equals to 5');
    expect(await championUpdatePage.getForceKeepRatingInput()).to.eq('5', 'Expected forceKeepRating value to be equals to 5');

    await championUpdatePage.save();
    expect(await championUpdatePage.getSaveButton().isPresent(), 'Expected save button disappear').to.be.false;

    expect(await championComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeCreate + 1, 'Expected one more entry in the table');
  });

  it('should delete last Champion', async () => {
    const nbButtonsBeforeDelete = await championComponentsPage.countDeleteButtons();
    await championComponentsPage.clickOnLastDeleteButton();

    championDeleteDialog = new ChampionDeleteDialog();
    expect(await championDeleteDialog.getDialogTitle()).to.eq('Are you sure you want to delete this Champion?');
    await championDeleteDialog.clickOnConfirmButton();

    expect(await championComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeDelete - 1);
  });

  after(async () => {
    await navBarPage.autoSignOut();
  });
});

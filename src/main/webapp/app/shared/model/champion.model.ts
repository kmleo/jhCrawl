export interface IChampion {
  id?: number;
  name?: string;
  faction?: string;
  rarity?: string;
  affinity?: string;
  role?: string;
  rank?: string;
  viewPageUrl?: string;
  fusion?: string;
  equipmentA?: string;
  equipmentB?: string;
  equipmentStatPriorityA?: string;
  equipmentStatPriorityB?: string;
  tier?: number;
  healthPoints?: number;
  attack?: number;
  defense?: number;
  speed?: number;
  criticalRate?: number;
  criticalDamage?: number;
  resistance?: number;
  accuracy?: number;
  campaignRating?: number;
  factionWarRating?: number;
  arenaOffenseRating?: number;
  arenaDefenseRating?: number;
  iceGolemRating?: number;
  spidersDenRating?: number;
  minotaursLabyrinthRating?: number;
  dragonsLairRating?: number;
  fireKnightsCastleRating?: number;
  voidKeepRating?: number;
  spiritKeepRating?: number;
  magicKeepRating?: number;
  forceKeepRating?: number;
}

export class Champion implements IChampion {
  constructor(
    public id?: number,
    public name?: string,
    public faction?: string,
    public rarity?: string,
    public affinity?: string,
    public role?: string,
    public rank?: string,
    public viewPageUrl?: string,
    public fusion?: string,
    public equipmentA?: string,
    public equipmentB?: string,
    public equipmentStatPriorityA?: string,
    public equipmentStatPriorityB?: string,
    public tier?: number,
    public healthPoints?: number,
    public attack?: number,
    public defense?: number,
    public speed?: number,
    public criticalRate?: number,
    public criticalDamage?: number,
    public resistance?: number,
    public accuracy?: number,
    public campaignRating?: number,
    public factionWarRating?: number,
    public arenaOffenseRating?: number,
    public arenaDefenseRating?: number,
    public iceGolemRating?: number,
    public spidersDenRating?: number,
    public minotaursLabyrinthRating?: number,
    public dragonsLairRating?: number,
    public fireKnightsCastleRating?: number,
    public voidKeepRating?: number,
    public spiritKeepRating?: number,
    public magicKeepRating?: number,
    public forceKeepRating?: number
  ) {}
}

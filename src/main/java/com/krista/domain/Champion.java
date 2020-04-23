package com.krista.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.FieldType;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Champion.
 */
@Entity
@Table(name = "champion")
@org.springframework.data.elasticsearch.annotations.Document(indexName = "champion")
public class Champion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "faction")
    private String faction;

    @Column(name = "rarity")
    private String rarity;

    @Column(name = "affinity")
    private String affinity;

    @Column(name = "role")
    private String role;

    @Column(name = "jhi_rank")
    private String rank;

    @Column(name = "view_page_url")
    private String viewPageUrl;

    @Column(name = "fusion")
    private String fusion;

    @Column(name = "equipment_a")
    private String equipmentA;

    @Column(name = "equipment_b")
    private String equipmentB;

    @Column(name = "equipment_stat_priority_a")
    private String equipmentStatPriorityA;

    @Column(name = "equipment_stat_priority_b")
    private String equipmentStatPriorityB;

    @Column(name = "tier")
    private Integer tier;

    @Column(name = "health_points")
    private Integer healthPoints;

    @Column(name = "attack")
    private Integer attack;

    @Column(name = "defense")
    private Integer defense;

    @Column(name = "speed")
    private Integer speed;

    @Column(name = "critical_rate")
    private Integer criticalRate;

    @Column(name = "critical_damage")
    private Integer criticalDamage;

    @Column(name = "resistance")
    private Integer resistance;

    @Column(name = "accuracy")
    private Integer accuracy;

    @Column(name = "campaign_rating")
    private Integer campaignRating;

    @Column(name = "faction_war_rating")
    private Integer factionWarRating;

    @Column(name = "arena_offense_rating")
    private Integer arenaOffenseRating;

    @Column(name = "arena_defense_rating")
    private Integer arenaDefenseRating;

    @Column(name = "ice_golem_rating")
    private Integer iceGolemRating;

    @Column(name = "spiders_den_rating")
    private Integer spidersDenRating;

    @Column(name = "minotaurs_labyrinth_rating")
    private Integer minotaursLabyrinthRating;

    @Column(name = "dragons_lair_rating")
    private Integer dragonsLairRating;

    @Column(name = "fire_knights_castle_rating")
    private Integer fireKnightsCastleRating;

    @Column(name = "void_keep_rating")
    private Integer voidKeepRating;

    @Column(name = "spirit_keep_rating")
    private Integer spiritKeepRating;

    @Column(name = "magic_keep_rating")
    private Integer magicKeepRating;

    @Column(name = "force_keep_rating")
    private Integer forceKeepRating;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Champion name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaction() {
        return faction;
    }

    public Champion faction(String faction) {
        this.faction = faction;
        return this;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    public String getRarity() {
        return rarity;
    }

    public Champion rarity(String rarity) {
        this.rarity = rarity;
        return this;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getAffinity() {
        return affinity;
    }

    public Champion affinity(String affinity) {
        this.affinity = affinity;
        return this;
    }

    public void setAffinity(String affinity) {
        this.affinity = affinity;
    }

    public String getRole() {
        return role;
    }

    public Champion role(String role) {
        this.role = role;
        return this;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRank() {
        return rank;
    }

    public Champion rank(String rank) {
        this.rank = rank;
        return this;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getViewPageUrl() {
        return viewPageUrl;
    }

    public Champion viewPageUrl(String viewPageUrl) {
        this.viewPageUrl = viewPageUrl;
        return this;
    }

    public void setViewPageUrl(String viewPageUrl) {
        this.viewPageUrl = viewPageUrl;
    }

    public String getFusion() {
        return fusion;
    }

    public Champion fusion(String fusion) {
        this.fusion = fusion;
        return this;
    }

    public void setFusion(String fusion) {
        this.fusion = fusion;
    }

    public String getEquipmentA() {
        return equipmentA;
    }

    public Champion equipmentA(String equipmentA) {
        this.equipmentA = equipmentA;
        return this;
    }

    public void setEquipmentA(String equipmentA) {
        this.equipmentA = equipmentA;
    }

    public String getEquipmentB() {
        return equipmentB;
    }

    public Champion equipmentB(String equipmentB) {
        this.equipmentB = equipmentB;
        return this;
    }

    public void setEquipmentB(String equipmentB) {
        this.equipmentB = equipmentB;
    }

    public String getEquipmentStatPriorityA() {
        return equipmentStatPriorityA;
    }

    public Champion equipmentStatPriorityA(String equipmentStatPriorityA) {
        this.equipmentStatPriorityA = equipmentStatPriorityA;
        return this;
    }

    public void setEquipmentStatPriorityA(String equipmentStatPriorityA) {
        this.equipmentStatPriorityA = equipmentStatPriorityA;
    }

    public String getEquipmentStatPriorityB() {
        return equipmentStatPriorityB;
    }

    public Champion equipmentStatPriorityB(String equipmentStatPriorityB) {
        this.equipmentStatPriorityB = equipmentStatPriorityB;
        return this;
    }

    public void setEquipmentStatPriorityB(String equipmentStatPriorityB) {
        this.equipmentStatPriorityB = equipmentStatPriorityB;
    }

    public Integer getTier() {
        return tier;
    }

    public Champion tier(Integer tier) {
        this.tier = tier;
        return this;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }

    public Integer getHealthPoints() {
        return healthPoints;
    }

    public Champion healthPoints(Integer healthPoints) {
        this.healthPoints = healthPoints;
        return this;
    }

    public void setHealthPoints(Integer healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Integer getAttack() {
        return attack;
    }

    public Champion attack(Integer attack) {
        this.attack = attack;
        return this;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public Champion defense(Integer defense) {
        this.defense = defense;
        return this;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getSpeed() {
        return speed;
    }

    public Champion speed(Integer speed) {
        this.speed = speed;
        return this;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getCriticalRate() {
        return criticalRate;
    }

    public Champion criticalRate(Integer criticalRate) {
        this.criticalRate = criticalRate;
        return this;
    }

    public void setCriticalRate(Integer criticalRate) {
        this.criticalRate = criticalRate;
    }

    public Integer getCriticalDamage() {
        return criticalDamage;
    }

    public Champion criticalDamage(Integer criticalDamage) {
        this.criticalDamage = criticalDamage;
        return this;
    }

    public void setCriticalDamage(Integer criticalDamage) {
        this.criticalDamage = criticalDamage;
    }

    public Integer getResistance() {
        return resistance;
    }

    public Champion resistance(Integer resistance) {
        this.resistance = resistance;
        return this;
    }

    public void setResistance(Integer resistance) {
        this.resistance = resistance;
    }

    public Integer getAccuracy() {
        return accuracy;
    }

    public Champion accuracy(Integer accuracy) {
        this.accuracy = accuracy;
        return this;
    }

    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    public Integer getCampaignRating() {
        return campaignRating;
    }

    public Champion campaignRating(Integer campaignRating) {
        this.campaignRating = campaignRating;
        return this;
    }

    public void setCampaignRating(Integer campaignRating) {
        this.campaignRating = campaignRating;
    }

    public Integer getFactionWarRating() {
        return factionWarRating;
    }

    public Champion factionWarRating(Integer factionWarRating) {
        this.factionWarRating = factionWarRating;
        return this;
    }

    public void setFactionWarRating(Integer factionWarRating) {
        this.factionWarRating = factionWarRating;
    }

    public Integer getArenaOffenseRating() {
        return arenaOffenseRating;
    }

    public Champion arenaOffenseRating(Integer arenaOffenseRating) {
        this.arenaOffenseRating = arenaOffenseRating;
        return this;
    }

    public void setArenaOffenseRating(Integer arenaOffenseRating) {
        this.arenaOffenseRating = arenaOffenseRating;
    }

    public Integer getArenaDefenseRating() {
        return arenaDefenseRating;
    }

    public Champion arenaDefenseRating(Integer arenaDefenseRating) {
        this.arenaDefenseRating = arenaDefenseRating;
        return this;
    }

    public void setArenaDefenseRating(Integer arenaDefenseRating) {
        this.arenaDefenseRating = arenaDefenseRating;
    }

    public Integer getIceGolemRating() {
        return iceGolemRating;
    }

    public Champion iceGolemRating(Integer iceGolemRating) {
        this.iceGolemRating = iceGolemRating;
        return this;
    }

    public void setIceGolemRating(Integer iceGolemRating) {
        this.iceGolemRating = iceGolemRating;
    }

    public Integer getSpidersDenRating() {
        return spidersDenRating;
    }

    public Champion spidersDenRating(Integer spidersDenRating) {
        this.spidersDenRating = spidersDenRating;
        return this;
    }

    public void setSpidersDenRating(Integer spidersDenRating) {
        this.spidersDenRating = spidersDenRating;
    }

    public Integer getMinotaursLabyrinthRating() {
        return minotaursLabyrinthRating;
    }

    public Champion minotaursLabyrinthRating(Integer minotaursLabyrinthRating) {
        this.minotaursLabyrinthRating = minotaursLabyrinthRating;
        return this;
    }

    public void setMinotaursLabyrinthRating(Integer minotaursLabyrinthRating) {
        this.minotaursLabyrinthRating = minotaursLabyrinthRating;
    }

    public Integer getDragonsLairRating() {
        return dragonsLairRating;
    }

    public Champion dragonsLairRating(Integer dragonsLairRating) {
        this.dragonsLairRating = dragonsLairRating;
        return this;
    }

    public void setDragonsLairRating(Integer dragonsLairRating) {
        this.dragonsLairRating = dragonsLairRating;
    }

    public Integer getFireKnightsCastleRating() {
        return fireKnightsCastleRating;
    }

    public Champion fireKnightsCastleRating(Integer fireKnightsCastleRating) {
        this.fireKnightsCastleRating = fireKnightsCastleRating;
        return this;
    }

    public void setFireKnightsCastleRating(Integer fireKnightsCastleRating) {
        this.fireKnightsCastleRating = fireKnightsCastleRating;
    }

    public Integer getVoidKeepRating() {
        return voidKeepRating;
    }

    public Champion voidKeepRating(Integer voidKeepRating) {
        this.voidKeepRating = voidKeepRating;
        return this;
    }

    public void setVoidKeepRating(Integer voidKeepRating) {
        this.voidKeepRating = voidKeepRating;
    }

    public Integer getSpiritKeepRating() {
        return spiritKeepRating;
    }

    public Champion spiritKeepRating(Integer spiritKeepRating) {
        this.spiritKeepRating = spiritKeepRating;
        return this;
    }

    public void setSpiritKeepRating(Integer spiritKeepRating) {
        this.spiritKeepRating = spiritKeepRating;
    }

    public Integer getMagicKeepRating() {
        return magicKeepRating;
    }

    public Champion magicKeepRating(Integer magicKeepRating) {
        this.magicKeepRating = magicKeepRating;
        return this;
    }

    public void setMagicKeepRating(Integer magicKeepRating) {
        this.magicKeepRating = magicKeepRating;
    }

    public Integer getForceKeepRating() {
        return forceKeepRating;
    }

    public Champion forceKeepRating(Integer forceKeepRating) {
        this.forceKeepRating = forceKeepRating;
        return this;
    }

    public void setForceKeepRating(Integer forceKeepRating) {
        this.forceKeepRating = forceKeepRating;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Champion)) {
            return false;
        }
        return id != null && id.equals(((Champion) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Champion{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", faction='" + getFaction() + "'" +
            ", rarity='" + getRarity() + "'" +
            ", affinity='" + getAffinity() + "'" +
            ", role='" + getRole() + "'" +
            ", rank='" + getRank() + "'" +
            ", viewPageUrl='" + getViewPageUrl() + "'" +
            ", fusion='" + getFusion() + "'" +
            ", equipmentA='" + getEquipmentA() + "'" +
            ", equipmentB='" + getEquipmentB() + "'" +
            ", equipmentStatPriorityA='" + getEquipmentStatPriorityA() + "'" +
            ", equipmentStatPriorityB='" + getEquipmentStatPriorityB() + "'" +
            ", tier=" + getTier() +
            ", healthPoints=" + getHealthPoints() +
            ", attack=" + getAttack() +
            ", defense=" + getDefense() +
            ", speed=" + getSpeed() +
            ", criticalRate=" + getCriticalRate() +
            ", criticalDamage=" + getCriticalDamage() +
            ", resistance=" + getResistance() +
            ", accuracy=" + getAccuracy() +
            ", campaignRating=" + getCampaignRating() +
            ", factionWarRating=" + getFactionWarRating() +
            ", arenaOffenseRating=" + getArenaOffenseRating() +
            ", arenaDefenseRating=" + getArenaDefenseRating() +
            ", iceGolemRating=" + getIceGolemRating() +
            ", spidersDenRating=" + getSpidersDenRating() +
            ", minotaursLabyrinthRating=" + getMinotaursLabyrinthRating() +
            ", dragonsLairRating=" + getDragonsLairRating() +
            ", fireKnightsCastleRating=" + getFireKnightsCastleRating() +
            ", voidKeepRating=" + getVoidKeepRating() +
            ", spiritKeepRating=" + getSpiritKeepRating() +
            ", magicKeepRating=" + getMagicKeepRating() +
            ", forceKeepRating=" + getForceKeepRating() +
            "}";
    }
}

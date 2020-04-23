package com.krista.web.rest;

import com.krista.JhCrawlApp;
import com.krista.domain.Champion;
import com.krista.repository.ChampionRepository;
import com.krista.repository.search.ChampionSearchRepository;
import com.krista.service.ChampionService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link ChampionResource} REST controller.
 */
@SpringBootTest(classes = JhCrawlApp.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@WithMockUser
public class ChampionResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_FACTION = "AAAAAAAAAA";
    private static final String UPDATED_FACTION = "BBBBBBBBBB";

    private static final String DEFAULT_RARITY = "AAAAAAAAAA";
    private static final String UPDATED_RARITY = "BBBBBBBBBB";

    private static final String DEFAULT_AFFINITY = "AAAAAAAAAA";
    private static final String UPDATED_AFFINITY = "BBBBBBBBBB";

    private static final String DEFAULT_ROLE = "AAAAAAAAAA";
    private static final String UPDATED_ROLE = "BBBBBBBBBB";

    private static final String DEFAULT_RANK = "AAAAAAAAAA";
    private static final String UPDATED_RANK = "BBBBBBBBBB";

    private static final String DEFAULT_VIEW_PAGE_URL = "AAAAAAAAAA";
    private static final String UPDATED_VIEW_PAGE_URL = "BBBBBBBBBB";

    private static final String DEFAULT_FUSION = "AAAAAAAAAA";
    private static final String UPDATED_FUSION = "BBBBBBBBBB";

    private static final String DEFAULT_EQUIPMENT_A = "AAAAAAAAAA";
    private static final String UPDATED_EQUIPMENT_A = "BBBBBBBBBB";

    private static final String DEFAULT_EQUIPMENT_B = "AAAAAAAAAA";
    private static final String UPDATED_EQUIPMENT_B = "BBBBBBBBBB";

    private static final String DEFAULT_EQUIPMENT_STAT_PRIORITY_A = "AAAAAAAAAA";
    private static final String UPDATED_EQUIPMENT_STAT_PRIORITY_A = "BBBBBBBBBB";

    private static final String DEFAULT_EQUIPMENT_STAT_PRIORITY_B = "AAAAAAAAAA";
    private static final String UPDATED_EQUIPMENT_STAT_PRIORITY_B = "BBBBBBBBBB";

    private static final Integer DEFAULT_TIER = 1;
    private static final Integer UPDATED_TIER = 2;

    private static final Integer DEFAULT_HEALTH_POINTS = 1;
    private static final Integer UPDATED_HEALTH_POINTS = 2;

    private static final Integer DEFAULT_ATTACK = 1;
    private static final Integer UPDATED_ATTACK = 2;

    private static final Integer DEFAULT_DEFENSE = 1;
    private static final Integer UPDATED_DEFENSE = 2;

    private static final Integer DEFAULT_SPEED = 1;
    private static final Integer UPDATED_SPEED = 2;

    private static final Integer DEFAULT_CRITICAL_RATE = 1;
    private static final Integer UPDATED_CRITICAL_RATE = 2;

    private static final Integer DEFAULT_CRITICAL_DAMAGE = 1;
    private static final Integer UPDATED_CRITICAL_DAMAGE = 2;

    private static final Integer DEFAULT_RESISTANCE = 1;
    private static final Integer UPDATED_RESISTANCE = 2;

    private static final Integer DEFAULT_ACCURACY = 1;
    private static final Integer UPDATED_ACCURACY = 2;

    private static final Integer DEFAULT_CAMPAIGN_RATING = 1;
    private static final Integer UPDATED_CAMPAIGN_RATING = 2;

    private static final Integer DEFAULT_FACTION_WAR_RATING = 1;
    private static final Integer UPDATED_FACTION_WAR_RATING = 2;

    private static final Integer DEFAULT_ARENA_OFFENSE_RATING = 1;
    private static final Integer UPDATED_ARENA_OFFENSE_RATING = 2;

    private static final Integer DEFAULT_ARENA_DEFENSE_RATING = 1;
    private static final Integer UPDATED_ARENA_DEFENSE_RATING = 2;

    private static final Integer DEFAULT_ICE_GOLEM_RATING = 1;
    private static final Integer UPDATED_ICE_GOLEM_RATING = 2;

    private static final Integer DEFAULT_SPIDERS_DEN_RATING = 1;
    private static final Integer UPDATED_SPIDERS_DEN_RATING = 2;

    private static final Integer DEFAULT_MINOTAURS_LABYRINTH_RATING = 1;
    private static final Integer UPDATED_MINOTAURS_LABYRINTH_RATING = 2;

    private static final Integer DEFAULT_DRAGONS_LAIR_RATING = 1;
    private static final Integer UPDATED_DRAGONS_LAIR_RATING = 2;

    private static final Integer DEFAULT_FIRE_KNIGHTS_CASTLE_RATING = 1;
    private static final Integer UPDATED_FIRE_KNIGHTS_CASTLE_RATING = 2;

    private static final Integer DEFAULT_VOID_KEEP_RATING = 1;
    private static final Integer UPDATED_VOID_KEEP_RATING = 2;

    private static final Integer DEFAULT_SPIRIT_KEEP_RATING = 1;
    private static final Integer UPDATED_SPIRIT_KEEP_RATING = 2;

    private static final Integer DEFAULT_MAGIC_KEEP_RATING = 1;
    private static final Integer UPDATED_MAGIC_KEEP_RATING = 2;

    private static final Integer DEFAULT_FORCE_KEEP_RATING = 1;
    private static final Integer UPDATED_FORCE_KEEP_RATING = 2;

    @Autowired
    private ChampionRepository championRepository;

    @Autowired
    private ChampionService championService;

    /**
     * This repository is mocked in the com.krista.repository.search test package.
     *
     * @see com.krista.repository.search.ChampionSearchRepositoryMockConfiguration
     */
    @Autowired
    private ChampionSearchRepository mockChampionSearchRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restChampionMockMvc;

    private Champion champion;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Champion createEntity(EntityManager em) {
        Champion champion = new Champion()
            .name(DEFAULT_NAME)
            .faction(DEFAULT_FACTION)
            .rarity(DEFAULT_RARITY)
            .affinity(DEFAULT_AFFINITY)
            .role(DEFAULT_ROLE)
            .rank(DEFAULT_RANK)
            .viewPageUrl(DEFAULT_VIEW_PAGE_URL)
            .fusion(DEFAULT_FUSION)
            .equipmentA(DEFAULT_EQUIPMENT_A)
            .equipmentB(DEFAULT_EQUIPMENT_B)
            .equipmentStatPriorityA(DEFAULT_EQUIPMENT_STAT_PRIORITY_A)
            .equipmentStatPriorityB(DEFAULT_EQUIPMENT_STAT_PRIORITY_B)
            .tier(DEFAULT_TIER)
            .healthPoints(DEFAULT_HEALTH_POINTS)
            .attack(DEFAULT_ATTACK)
            .defense(DEFAULT_DEFENSE)
            .speed(DEFAULT_SPEED)
            .criticalRate(DEFAULT_CRITICAL_RATE)
            .criticalDamage(DEFAULT_CRITICAL_DAMAGE)
            .resistance(DEFAULT_RESISTANCE)
            .accuracy(DEFAULT_ACCURACY)
            .campaignRating(DEFAULT_CAMPAIGN_RATING)
            .factionWarRating(DEFAULT_FACTION_WAR_RATING)
            .arenaOffenseRating(DEFAULT_ARENA_OFFENSE_RATING)
            .arenaDefenseRating(DEFAULT_ARENA_DEFENSE_RATING)
            .iceGolemRating(DEFAULT_ICE_GOLEM_RATING)
            .spidersDenRating(DEFAULT_SPIDERS_DEN_RATING)
            .minotaursLabyrinthRating(DEFAULT_MINOTAURS_LABYRINTH_RATING)
            .dragonsLairRating(DEFAULT_DRAGONS_LAIR_RATING)
            .fireKnightsCastleRating(DEFAULT_FIRE_KNIGHTS_CASTLE_RATING)
            .voidKeepRating(DEFAULT_VOID_KEEP_RATING)
            .spiritKeepRating(DEFAULT_SPIRIT_KEEP_RATING)
            .magicKeepRating(DEFAULT_MAGIC_KEEP_RATING)
            .forceKeepRating(DEFAULT_FORCE_KEEP_RATING);
        return champion;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Champion createUpdatedEntity(EntityManager em) {
        Champion champion = new Champion()
            .name(UPDATED_NAME)
            .faction(UPDATED_FACTION)
            .rarity(UPDATED_RARITY)
            .affinity(UPDATED_AFFINITY)
            .role(UPDATED_ROLE)
            .rank(UPDATED_RANK)
            .viewPageUrl(UPDATED_VIEW_PAGE_URL)
            .fusion(UPDATED_FUSION)
            .equipmentA(UPDATED_EQUIPMENT_A)
            .equipmentB(UPDATED_EQUIPMENT_B)
            .equipmentStatPriorityA(UPDATED_EQUIPMENT_STAT_PRIORITY_A)
            .equipmentStatPriorityB(UPDATED_EQUIPMENT_STAT_PRIORITY_B)
            .tier(UPDATED_TIER)
            .healthPoints(UPDATED_HEALTH_POINTS)
            .attack(UPDATED_ATTACK)
            .defense(UPDATED_DEFENSE)
            .speed(UPDATED_SPEED)
            .criticalRate(UPDATED_CRITICAL_RATE)
            .criticalDamage(UPDATED_CRITICAL_DAMAGE)
            .resistance(UPDATED_RESISTANCE)
            .accuracy(UPDATED_ACCURACY)
            .campaignRating(UPDATED_CAMPAIGN_RATING)
            .factionWarRating(UPDATED_FACTION_WAR_RATING)
            .arenaOffenseRating(UPDATED_ARENA_OFFENSE_RATING)
            .arenaDefenseRating(UPDATED_ARENA_DEFENSE_RATING)
            .iceGolemRating(UPDATED_ICE_GOLEM_RATING)
            .spidersDenRating(UPDATED_SPIDERS_DEN_RATING)
            .minotaursLabyrinthRating(UPDATED_MINOTAURS_LABYRINTH_RATING)
            .dragonsLairRating(UPDATED_DRAGONS_LAIR_RATING)
            .fireKnightsCastleRating(UPDATED_FIRE_KNIGHTS_CASTLE_RATING)
            .voidKeepRating(UPDATED_VOID_KEEP_RATING)
            .spiritKeepRating(UPDATED_SPIRIT_KEEP_RATING)
            .magicKeepRating(UPDATED_MAGIC_KEEP_RATING)
            .forceKeepRating(UPDATED_FORCE_KEEP_RATING);
        return champion;
    }

    @BeforeEach
    public void initTest() {
        champion = createEntity(em);
    }

    @Test
    @Transactional
    public void createChampion() throws Exception {
        int databaseSizeBeforeCreate = championRepository.findAll().size();

        // Create the Champion
        restChampionMockMvc.perform(post("/api/champions").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(champion)))
            .andExpect(status().isCreated());

        // Validate the Champion in the database
        List<Champion> championList = championRepository.findAll();
        assertThat(championList).hasSize(databaseSizeBeforeCreate + 1);
        Champion testChampion = championList.get(championList.size() - 1);
        assertThat(testChampion.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testChampion.getFaction()).isEqualTo(DEFAULT_FACTION);
        assertThat(testChampion.getRarity()).isEqualTo(DEFAULT_RARITY);
        assertThat(testChampion.getAffinity()).isEqualTo(DEFAULT_AFFINITY);
        assertThat(testChampion.getRole()).isEqualTo(DEFAULT_ROLE);
        assertThat(testChampion.getRank()).isEqualTo(DEFAULT_RANK);
        assertThat(testChampion.getViewPageUrl()).isEqualTo(DEFAULT_VIEW_PAGE_URL);
        assertThat(testChampion.getFusion()).isEqualTo(DEFAULT_FUSION);
        assertThat(testChampion.getEquipmentA()).isEqualTo(DEFAULT_EQUIPMENT_A);
        assertThat(testChampion.getEquipmentB()).isEqualTo(DEFAULT_EQUIPMENT_B);
        assertThat(testChampion.getEquipmentStatPriorityA()).isEqualTo(DEFAULT_EQUIPMENT_STAT_PRIORITY_A);
        assertThat(testChampion.getEquipmentStatPriorityB()).isEqualTo(DEFAULT_EQUIPMENT_STAT_PRIORITY_B);
        assertThat(testChampion.getTier()).isEqualTo(DEFAULT_TIER);
        assertThat(testChampion.getHealthPoints()).isEqualTo(DEFAULT_HEALTH_POINTS);
        assertThat(testChampion.getAttack()).isEqualTo(DEFAULT_ATTACK);
        assertThat(testChampion.getDefense()).isEqualTo(DEFAULT_DEFENSE);
        assertThat(testChampion.getSpeed()).isEqualTo(DEFAULT_SPEED);
        assertThat(testChampion.getCriticalRate()).isEqualTo(DEFAULT_CRITICAL_RATE);
        assertThat(testChampion.getCriticalDamage()).isEqualTo(DEFAULT_CRITICAL_DAMAGE);
        assertThat(testChampion.getResistance()).isEqualTo(DEFAULT_RESISTANCE);
        assertThat(testChampion.getAccuracy()).isEqualTo(DEFAULT_ACCURACY);
        assertThat(testChampion.getCampaignRating()).isEqualTo(DEFAULT_CAMPAIGN_RATING);
        assertThat(testChampion.getFactionWarRating()).isEqualTo(DEFAULT_FACTION_WAR_RATING);
        assertThat(testChampion.getArenaOffenseRating()).isEqualTo(DEFAULT_ARENA_OFFENSE_RATING);
        assertThat(testChampion.getArenaDefenseRating()).isEqualTo(DEFAULT_ARENA_DEFENSE_RATING);
        assertThat(testChampion.getIceGolemRating()).isEqualTo(DEFAULT_ICE_GOLEM_RATING);
        assertThat(testChampion.getSpidersDenRating()).isEqualTo(DEFAULT_SPIDERS_DEN_RATING);
        assertThat(testChampion.getMinotaursLabyrinthRating()).isEqualTo(DEFAULT_MINOTAURS_LABYRINTH_RATING);
        assertThat(testChampion.getDragonsLairRating()).isEqualTo(DEFAULT_DRAGONS_LAIR_RATING);
        assertThat(testChampion.getFireKnightsCastleRating()).isEqualTo(DEFAULT_FIRE_KNIGHTS_CASTLE_RATING);
        assertThat(testChampion.getVoidKeepRating()).isEqualTo(DEFAULT_VOID_KEEP_RATING);
        assertThat(testChampion.getSpiritKeepRating()).isEqualTo(DEFAULT_SPIRIT_KEEP_RATING);
        assertThat(testChampion.getMagicKeepRating()).isEqualTo(DEFAULT_MAGIC_KEEP_RATING);
        assertThat(testChampion.getForceKeepRating()).isEqualTo(DEFAULT_FORCE_KEEP_RATING);

        // Validate the Champion in Elasticsearch
        verify(mockChampionSearchRepository, times(1)).save(testChampion);
    }

    @Test
    @Transactional
    public void createChampionWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = championRepository.findAll().size();

        // Create the Champion with an existing ID
        champion.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restChampionMockMvc.perform(post("/api/champions").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(champion)))
            .andExpect(status().isBadRequest());

        // Validate the Champion in the database
        List<Champion> championList = championRepository.findAll();
        assertThat(championList).hasSize(databaseSizeBeforeCreate);

        // Validate the Champion in Elasticsearch
        verify(mockChampionSearchRepository, times(0)).save(champion);
    }


    @Test
    @Transactional
    public void checkNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = championRepository.findAll().size();
        // set the field null
        champion.setName(null);

        // Create the Champion, which fails.

        restChampionMockMvc.perform(post("/api/champions").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(champion)))
            .andExpect(status().isBadRequest());

        List<Champion> championList = championRepository.findAll();
        assertThat(championList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllChampions() throws Exception {
        // Initialize the database
        championRepository.saveAndFlush(champion);

        // Get all the championList
        restChampionMockMvc.perform(get("/api/champions?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(champion.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].faction").value(hasItem(DEFAULT_FACTION)))
            .andExpect(jsonPath("$.[*].rarity").value(hasItem(DEFAULT_RARITY)))
            .andExpect(jsonPath("$.[*].affinity").value(hasItem(DEFAULT_AFFINITY)))
            .andExpect(jsonPath("$.[*].role").value(hasItem(DEFAULT_ROLE)))
            .andExpect(jsonPath("$.[*].rank").value(hasItem(DEFAULT_RANK)))
            .andExpect(jsonPath("$.[*].viewPageUrl").value(hasItem(DEFAULT_VIEW_PAGE_URL)))
            .andExpect(jsonPath("$.[*].fusion").value(hasItem(DEFAULT_FUSION)))
            .andExpect(jsonPath("$.[*].equipmentA").value(hasItem(DEFAULT_EQUIPMENT_A)))
            .andExpect(jsonPath("$.[*].equipmentB").value(hasItem(DEFAULT_EQUIPMENT_B)))
            .andExpect(jsonPath("$.[*].equipmentStatPriorityA").value(hasItem(DEFAULT_EQUIPMENT_STAT_PRIORITY_A)))
            .andExpect(jsonPath("$.[*].equipmentStatPriorityB").value(hasItem(DEFAULT_EQUIPMENT_STAT_PRIORITY_B)))
            .andExpect(jsonPath("$.[*].tier").value(hasItem(DEFAULT_TIER)))
            .andExpect(jsonPath("$.[*].healthPoints").value(hasItem(DEFAULT_HEALTH_POINTS)))
            .andExpect(jsonPath("$.[*].attack").value(hasItem(DEFAULT_ATTACK)))
            .andExpect(jsonPath("$.[*].defense").value(hasItem(DEFAULT_DEFENSE)))
            .andExpect(jsonPath("$.[*].speed").value(hasItem(DEFAULT_SPEED)))
            .andExpect(jsonPath("$.[*].criticalRate").value(hasItem(DEFAULT_CRITICAL_RATE)))
            .andExpect(jsonPath("$.[*].criticalDamage").value(hasItem(DEFAULT_CRITICAL_DAMAGE)))
            .andExpect(jsonPath("$.[*].resistance").value(hasItem(DEFAULT_RESISTANCE)))
            .andExpect(jsonPath("$.[*].accuracy").value(hasItem(DEFAULT_ACCURACY)))
            .andExpect(jsonPath("$.[*].campaignRating").value(hasItem(DEFAULT_CAMPAIGN_RATING)))
            .andExpect(jsonPath("$.[*].factionWarRating").value(hasItem(DEFAULT_FACTION_WAR_RATING)))
            .andExpect(jsonPath("$.[*].arenaOffenseRating").value(hasItem(DEFAULT_ARENA_OFFENSE_RATING)))
            .andExpect(jsonPath("$.[*].arenaDefenseRating").value(hasItem(DEFAULT_ARENA_DEFENSE_RATING)))
            .andExpect(jsonPath("$.[*].iceGolemRating").value(hasItem(DEFAULT_ICE_GOLEM_RATING)))
            .andExpect(jsonPath("$.[*].spidersDenRating").value(hasItem(DEFAULT_SPIDERS_DEN_RATING)))
            .andExpect(jsonPath("$.[*].minotaursLabyrinthRating").value(hasItem(DEFAULT_MINOTAURS_LABYRINTH_RATING)))
            .andExpect(jsonPath("$.[*].dragonsLairRating").value(hasItem(DEFAULT_DRAGONS_LAIR_RATING)))
            .andExpect(jsonPath("$.[*].fireKnightsCastleRating").value(hasItem(DEFAULT_FIRE_KNIGHTS_CASTLE_RATING)))
            .andExpect(jsonPath("$.[*].voidKeepRating").value(hasItem(DEFAULT_VOID_KEEP_RATING)))
            .andExpect(jsonPath("$.[*].spiritKeepRating").value(hasItem(DEFAULT_SPIRIT_KEEP_RATING)))
            .andExpect(jsonPath("$.[*].magicKeepRating").value(hasItem(DEFAULT_MAGIC_KEEP_RATING)))
            .andExpect(jsonPath("$.[*].forceKeepRating").value(hasItem(DEFAULT_FORCE_KEEP_RATING)));
    }
    
    @Test
    @Transactional
    public void getChampion() throws Exception {
        // Initialize the database
        championRepository.saveAndFlush(champion);

        // Get the champion
        restChampionMockMvc.perform(get("/api/champions/{id}", champion.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(champion.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.faction").value(DEFAULT_FACTION))
            .andExpect(jsonPath("$.rarity").value(DEFAULT_RARITY))
            .andExpect(jsonPath("$.affinity").value(DEFAULT_AFFINITY))
            .andExpect(jsonPath("$.role").value(DEFAULT_ROLE))
            .andExpect(jsonPath("$.rank").value(DEFAULT_RANK))
            .andExpect(jsonPath("$.viewPageUrl").value(DEFAULT_VIEW_PAGE_URL))
            .andExpect(jsonPath("$.fusion").value(DEFAULT_FUSION))
            .andExpect(jsonPath("$.equipmentA").value(DEFAULT_EQUIPMENT_A))
            .andExpect(jsonPath("$.equipmentB").value(DEFAULT_EQUIPMENT_B))
            .andExpect(jsonPath("$.equipmentStatPriorityA").value(DEFAULT_EQUIPMENT_STAT_PRIORITY_A))
            .andExpect(jsonPath("$.equipmentStatPriorityB").value(DEFAULT_EQUIPMENT_STAT_PRIORITY_B))
            .andExpect(jsonPath("$.tier").value(DEFAULT_TIER))
            .andExpect(jsonPath("$.healthPoints").value(DEFAULT_HEALTH_POINTS))
            .andExpect(jsonPath("$.attack").value(DEFAULT_ATTACK))
            .andExpect(jsonPath("$.defense").value(DEFAULT_DEFENSE))
            .andExpect(jsonPath("$.speed").value(DEFAULT_SPEED))
            .andExpect(jsonPath("$.criticalRate").value(DEFAULT_CRITICAL_RATE))
            .andExpect(jsonPath("$.criticalDamage").value(DEFAULT_CRITICAL_DAMAGE))
            .andExpect(jsonPath("$.resistance").value(DEFAULT_RESISTANCE))
            .andExpect(jsonPath("$.accuracy").value(DEFAULT_ACCURACY))
            .andExpect(jsonPath("$.campaignRating").value(DEFAULT_CAMPAIGN_RATING))
            .andExpect(jsonPath("$.factionWarRating").value(DEFAULT_FACTION_WAR_RATING))
            .andExpect(jsonPath("$.arenaOffenseRating").value(DEFAULT_ARENA_OFFENSE_RATING))
            .andExpect(jsonPath("$.arenaDefenseRating").value(DEFAULT_ARENA_DEFENSE_RATING))
            .andExpect(jsonPath("$.iceGolemRating").value(DEFAULT_ICE_GOLEM_RATING))
            .andExpect(jsonPath("$.spidersDenRating").value(DEFAULT_SPIDERS_DEN_RATING))
            .andExpect(jsonPath("$.minotaursLabyrinthRating").value(DEFAULT_MINOTAURS_LABYRINTH_RATING))
            .andExpect(jsonPath("$.dragonsLairRating").value(DEFAULT_DRAGONS_LAIR_RATING))
            .andExpect(jsonPath("$.fireKnightsCastleRating").value(DEFAULT_FIRE_KNIGHTS_CASTLE_RATING))
            .andExpect(jsonPath("$.voidKeepRating").value(DEFAULT_VOID_KEEP_RATING))
            .andExpect(jsonPath("$.spiritKeepRating").value(DEFAULT_SPIRIT_KEEP_RATING))
            .andExpect(jsonPath("$.magicKeepRating").value(DEFAULT_MAGIC_KEEP_RATING))
            .andExpect(jsonPath("$.forceKeepRating").value(DEFAULT_FORCE_KEEP_RATING));
    }

    @Test
    @Transactional
    public void getNonExistingChampion() throws Exception {
        // Get the champion
        restChampionMockMvc.perform(get("/api/champions/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateChampion() throws Exception {
        // Initialize the database
        championService.save(champion);
        // As the test used the service layer, reset the Elasticsearch mock repository
        reset(mockChampionSearchRepository);

        int databaseSizeBeforeUpdate = championRepository.findAll().size();

        // Update the champion
        Champion updatedChampion = championRepository.findById(champion.getId()).get();
        // Disconnect from session so that the updates on updatedChampion are not directly saved in db
        em.detach(updatedChampion);
        updatedChampion
            .name(UPDATED_NAME)
            .faction(UPDATED_FACTION)
            .rarity(UPDATED_RARITY)
            .affinity(UPDATED_AFFINITY)
            .role(UPDATED_ROLE)
            .rank(UPDATED_RANK)
            .viewPageUrl(UPDATED_VIEW_PAGE_URL)
            .fusion(UPDATED_FUSION)
            .equipmentA(UPDATED_EQUIPMENT_A)
            .equipmentB(UPDATED_EQUIPMENT_B)
            .equipmentStatPriorityA(UPDATED_EQUIPMENT_STAT_PRIORITY_A)
            .equipmentStatPriorityB(UPDATED_EQUIPMENT_STAT_PRIORITY_B)
            .tier(UPDATED_TIER)
            .healthPoints(UPDATED_HEALTH_POINTS)
            .attack(UPDATED_ATTACK)
            .defense(UPDATED_DEFENSE)
            .speed(UPDATED_SPEED)
            .criticalRate(UPDATED_CRITICAL_RATE)
            .criticalDamage(UPDATED_CRITICAL_DAMAGE)
            .resistance(UPDATED_RESISTANCE)
            .accuracy(UPDATED_ACCURACY)
            .campaignRating(UPDATED_CAMPAIGN_RATING)
            .factionWarRating(UPDATED_FACTION_WAR_RATING)
            .arenaOffenseRating(UPDATED_ARENA_OFFENSE_RATING)
            .arenaDefenseRating(UPDATED_ARENA_DEFENSE_RATING)
            .iceGolemRating(UPDATED_ICE_GOLEM_RATING)
            .spidersDenRating(UPDATED_SPIDERS_DEN_RATING)
            .minotaursLabyrinthRating(UPDATED_MINOTAURS_LABYRINTH_RATING)
            .dragonsLairRating(UPDATED_DRAGONS_LAIR_RATING)
            .fireKnightsCastleRating(UPDATED_FIRE_KNIGHTS_CASTLE_RATING)
            .voidKeepRating(UPDATED_VOID_KEEP_RATING)
            .spiritKeepRating(UPDATED_SPIRIT_KEEP_RATING)
            .magicKeepRating(UPDATED_MAGIC_KEEP_RATING)
            .forceKeepRating(UPDATED_FORCE_KEEP_RATING);

        restChampionMockMvc.perform(put("/api/champions").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedChampion)))
            .andExpect(status().isOk());

        // Validate the Champion in the database
        List<Champion> championList = championRepository.findAll();
        assertThat(championList).hasSize(databaseSizeBeforeUpdate);
        Champion testChampion = championList.get(championList.size() - 1);
        assertThat(testChampion.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testChampion.getFaction()).isEqualTo(UPDATED_FACTION);
        assertThat(testChampion.getRarity()).isEqualTo(UPDATED_RARITY);
        assertThat(testChampion.getAffinity()).isEqualTo(UPDATED_AFFINITY);
        assertThat(testChampion.getRole()).isEqualTo(UPDATED_ROLE);
        assertThat(testChampion.getRank()).isEqualTo(UPDATED_RANK);
        assertThat(testChampion.getViewPageUrl()).isEqualTo(UPDATED_VIEW_PAGE_URL);
        assertThat(testChampion.getFusion()).isEqualTo(UPDATED_FUSION);
        assertThat(testChampion.getEquipmentA()).isEqualTo(UPDATED_EQUIPMENT_A);
        assertThat(testChampion.getEquipmentB()).isEqualTo(UPDATED_EQUIPMENT_B);
        assertThat(testChampion.getEquipmentStatPriorityA()).isEqualTo(UPDATED_EQUIPMENT_STAT_PRIORITY_A);
        assertThat(testChampion.getEquipmentStatPriorityB()).isEqualTo(UPDATED_EQUIPMENT_STAT_PRIORITY_B);
        assertThat(testChampion.getTier()).isEqualTo(UPDATED_TIER);
        assertThat(testChampion.getHealthPoints()).isEqualTo(UPDATED_HEALTH_POINTS);
        assertThat(testChampion.getAttack()).isEqualTo(UPDATED_ATTACK);
        assertThat(testChampion.getDefense()).isEqualTo(UPDATED_DEFENSE);
        assertThat(testChampion.getSpeed()).isEqualTo(UPDATED_SPEED);
        assertThat(testChampion.getCriticalRate()).isEqualTo(UPDATED_CRITICAL_RATE);
        assertThat(testChampion.getCriticalDamage()).isEqualTo(UPDATED_CRITICAL_DAMAGE);
        assertThat(testChampion.getResistance()).isEqualTo(UPDATED_RESISTANCE);
        assertThat(testChampion.getAccuracy()).isEqualTo(UPDATED_ACCURACY);
        assertThat(testChampion.getCampaignRating()).isEqualTo(UPDATED_CAMPAIGN_RATING);
        assertThat(testChampion.getFactionWarRating()).isEqualTo(UPDATED_FACTION_WAR_RATING);
        assertThat(testChampion.getArenaOffenseRating()).isEqualTo(UPDATED_ARENA_OFFENSE_RATING);
        assertThat(testChampion.getArenaDefenseRating()).isEqualTo(UPDATED_ARENA_DEFENSE_RATING);
        assertThat(testChampion.getIceGolemRating()).isEqualTo(UPDATED_ICE_GOLEM_RATING);
        assertThat(testChampion.getSpidersDenRating()).isEqualTo(UPDATED_SPIDERS_DEN_RATING);
        assertThat(testChampion.getMinotaursLabyrinthRating()).isEqualTo(UPDATED_MINOTAURS_LABYRINTH_RATING);
        assertThat(testChampion.getDragonsLairRating()).isEqualTo(UPDATED_DRAGONS_LAIR_RATING);
        assertThat(testChampion.getFireKnightsCastleRating()).isEqualTo(UPDATED_FIRE_KNIGHTS_CASTLE_RATING);
        assertThat(testChampion.getVoidKeepRating()).isEqualTo(UPDATED_VOID_KEEP_RATING);
        assertThat(testChampion.getSpiritKeepRating()).isEqualTo(UPDATED_SPIRIT_KEEP_RATING);
        assertThat(testChampion.getMagicKeepRating()).isEqualTo(UPDATED_MAGIC_KEEP_RATING);
        assertThat(testChampion.getForceKeepRating()).isEqualTo(UPDATED_FORCE_KEEP_RATING);

        // Validate the Champion in Elasticsearch
        verify(mockChampionSearchRepository, times(1)).save(testChampion);
    }

    @Test
    @Transactional
    public void updateNonExistingChampion() throws Exception {
        int databaseSizeBeforeUpdate = championRepository.findAll().size();

        // Create the Champion

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restChampionMockMvc.perform(put("/api/champions").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(champion)))
            .andExpect(status().isBadRequest());

        // Validate the Champion in the database
        List<Champion> championList = championRepository.findAll();
        assertThat(championList).hasSize(databaseSizeBeforeUpdate);

        // Validate the Champion in Elasticsearch
        verify(mockChampionSearchRepository, times(0)).save(champion);
    }

    @Test
    @Transactional
    public void deleteChampion() throws Exception {
        // Initialize the database
        championService.save(champion);

        int databaseSizeBeforeDelete = championRepository.findAll().size();

        // Delete the champion
        restChampionMockMvc.perform(delete("/api/champions/{id}", champion.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Champion> championList = championRepository.findAll();
        assertThat(championList).hasSize(databaseSizeBeforeDelete - 1);

        // Validate the Champion in Elasticsearch
        verify(mockChampionSearchRepository, times(1)).deleteById(champion.getId());
    }

    @Test
    @Transactional
    public void searchChampion() throws Exception {
        // Initialize the database
        championService.save(champion);
        when(mockChampionSearchRepository.search(queryStringQuery("id:" + champion.getId()), PageRequest.of(0, 20)))
            .thenReturn(new PageImpl<>(Collections.singletonList(champion), PageRequest.of(0, 1), 1));
        // Search the champion
        restChampionMockMvc.perform(get("/api/_search/champions?query=id:" + champion.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(champion.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].faction").value(hasItem(DEFAULT_FACTION)))
            .andExpect(jsonPath("$.[*].rarity").value(hasItem(DEFAULT_RARITY)))
            .andExpect(jsonPath("$.[*].affinity").value(hasItem(DEFAULT_AFFINITY)))
            .andExpect(jsonPath("$.[*].role").value(hasItem(DEFAULT_ROLE)))
            .andExpect(jsonPath("$.[*].rank").value(hasItem(DEFAULT_RANK)))
            .andExpect(jsonPath("$.[*].viewPageUrl").value(hasItem(DEFAULT_VIEW_PAGE_URL)))
            .andExpect(jsonPath("$.[*].fusion").value(hasItem(DEFAULT_FUSION)))
            .andExpect(jsonPath("$.[*].equipmentA").value(hasItem(DEFAULT_EQUIPMENT_A)))
            .andExpect(jsonPath("$.[*].equipmentB").value(hasItem(DEFAULT_EQUIPMENT_B)))
            .andExpect(jsonPath("$.[*].equipmentStatPriorityA").value(hasItem(DEFAULT_EQUIPMENT_STAT_PRIORITY_A)))
            .andExpect(jsonPath("$.[*].equipmentStatPriorityB").value(hasItem(DEFAULT_EQUIPMENT_STAT_PRIORITY_B)))
            .andExpect(jsonPath("$.[*].tier").value(hasItem(DEFAULT_TIER)))
            .andExpect(jsonPath("$.[*].healthPoints").value(hasItem(DEFAULT_HEALTH_POINTS)))
            .andExpect(jsonPath("$.[*].attack").value(hasItem(DEFAULT_ATTACK)))
            .andExpect(jsonPath("$.[*].defense").value(hasItem(DEFAULT_DEFENSE)))
            .andExpect(jsonPath("$.[*].speed").value(hasItem(DEFAULT_SPEED)))
            .andExpect(jsonPath("$.[*].criticalRate").value(hasItem(DEFAULT_CRITICAL_RATE)))
            .andExpect(jsonPath("$.[*].criticalDamage").value(hasItem(DEFAULT_CRITICAL_DAMAGE)))
            .andExpect(jsonPath("$.[*].resistance").value(hasItem(DEFAULT_RESISTANCE)))
            .andExpect(jsonPath("$.[*].accuracy").value(hasItem(DEFAULT_ACCURACY)))
            .andExpect(jsonPath("$.[*].campaignRating").value(hasItem(DEFAULT_CAMPAIGN_RATING)))
            .andExpect(jsonPath("$.[*].factionWarRating").value(hasItem(DEFAULT_FACTION_WAR_RATING)))
            .andExpect(jsonPath("$.[*].arenaOffenseRating").value(hasItem(DEFAULT_ARENA_OFFENSE_RATING)))
            .andExpect(jsonPath("$.[*].arenaDefenseRating").value(hasItem(DEFAULT_ARENA_DEFENSE_RATING)))
            .andExpect(jsonPath("$.[*].iceGolemRating").value(hasItem(DEFAULT_ICE_GOLEM_RATING)))
            .andExpect(jsonPath("$.[*].spidersDenRating").value(hasItem(DEFAULT_SPIDERS_DEN_RATING)))
            .andExpect(jsonPath("$.[*].minotaursLabyrinthRating").value(hasItem(DEFAULT_MINOTAURS_LABYRINTH_RATING)))
            .andExpect(jsonPath("$.[*].dragonsLairRating").value(hasItem(DEFAULT_DRAGONS_LAIR_RATING)))
            .andExpect(jsonPath("$.[*].fireKnightsCastleRating").value(hasItem(DEFAULT_FIRE_KNIGHTS_CASTLE_RATING)))
            .andExpect(jsonPath("$.[*].voidKeepRating").value(hasItem(DEFAULT_VOID_KEEP_RATING)))
            .andExpect(jsonPath("$.[*].spiritKeepRating").value(hasItem(DEFAULT_SPIRIT_KEEP_RATING)))
            .andExpect(jsonPath("$.[*].magicKeepRating").value(hasItem(DEFAULT_MAGIC_KEEP_RATING)))
            .andExpect(jsonPath("$.[*].forceKeepRating").value(hasItem(DEFAULT_FORCE_KEEP_RATING)));
    }
}

package com.krista.service;

import com.krista.domain.Champion;
import com.krista.repository.ChampionRepository;
import com.krista.repository.search.ChampionSearchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing {@link Champion}.
 */
@Service
@Transactional
public class ChampionService {

    private final Logger log = LoggerFactory.getLogger(ChampionService.class);

    private final ChampionRepository championRepository;

    private final ChampionSearchRepository championSearchRepository;

    public ChampionService(ChampionRepository championRepository, ChampionSearchRepository championSearchRepository) {
        this.championRepository = championRepository;
        this.championSearchRepository = championSearchRepository;
    }

    /**
     * Save a champion.
     *
     * @param champion the entity to save.
     * @return the persisted entity.
     */
    public Champion save(Champion champion) {
        log.debug("Request to save Champion : {}", champion);
        Champion result = championRepository.save(champion);
        championSearchRepository.save(result);
        return result;
    }

    /**
     * Get all the champions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Champion> findAll(Pageable pageable) {
        log.debug("Request to get all Champions");
        return championRepository.findAll(pageable);
    }

    /**
     * Get one champion by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Champion> findOne(Long id) {
        log.debug("Request to get Champion : {}", id);
        return championRepository.findById(id);
    }

    /**
     * Delete the champion by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Champion : {}", id);
        championRepository.deleteById(id);
        championSearchRepository.deleteById(id);
    }

    /**
     * Search for the champion corresponding to the query.
     *
     * @param query the query of the search.
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Champion> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Champions for query {}", query);
        return championSearchRepository.search(queryStringQuery(query), pageable);    }
}

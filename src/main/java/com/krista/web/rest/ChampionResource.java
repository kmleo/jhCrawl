package com.krista.web.rest;

import com.krista.domain.Champion;
import com.krista.service.ChampionService;
import com.krista.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing {@link com.krista.domain.Champion}.
 */
@RestController
@RequestMapping("/api")
public class ChampionResource {

    private final Logger log = LoggerFactory.getLogger(ChampionResource.class);

    private static final String ENTITY_NAME = "champion";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ChampionService championService;

    public ChampionResource(ChampionService championService) {
        this.championService = championService;
    }

    /**
     * {@code POST  /champions} : Create a new champion.
     *
     * @param champion the champion to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new champion, or with status {@code 400 (Bad Request)} if the champion has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/champions")
    public ResponseEntity<Champion> createChampion(@Valid @RequestBody Champion champion) throws URISyntaxException {
        log.debug("REST request to save Champion : {}", champion);
        if (champion.getId() != null) {
            throw new BadRequestAlertException("A new champion cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Champion result = championService.save(champion);
        return ResponseEntity.created(new URI("/api/champions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /champions} : Updates an existing champion.
     *
     * @param champion the champion to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated champion,
     * or with status {@code 400 (Bad Request)} if the champion is not valid,
     * or with status {@code 500 (Internal Server Error)} if the champion couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/champions")
    public ResponseEntity<Champion> updateChampion(@Valid @RequestBody Champion champion) throws URISyntaxException {
        log.debug("REST request to update Champion : {}", champion);
        if (champion.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Champion result = championService.save(champion);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, champion.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /champions} : get all the champions.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of champions in body.
     */
    @GetMapping("/champions")
    public ResponseEntity<List<Champion>> getAllChampions(Pageable pageable) {
        log.debug("REST request to get a page of Champions");
        Page<Champion> page = championService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /champions/:id} : get the "id" champion.
     *
     * @param id the id of the champion to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the champion, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/champions/{id}")
    public ResponseEntity<Champion> getChampion(@PathVariable Long id) {
        log.debug("REST request to get Champion : {}", id);
        Optional<Champion> champion = championService.findOne(id);
        return ResponseUtil.wrapOrNotFound(champion);
    }

    /**
     * {@code DELETE  /champions/:id} : delete the "id" champion.
     *
     * @param id the id of the champion to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/champions/{id}")
    public ResponseEntity<Void> deleteChampion(@PathVariable Long id) {
        log.debug("REST request to delete Champion : {}", id);
        championService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }

    /**
     * {@code SEARCH  /_search/champions?query=:query} : search for the champion corresponding
     * to the query.
     *
     * @param query the query of the champion search.
     * @param pageable the pagination information.
     * @return the result of the search.
     */
    @GetMapping("/_search/champions")
    public ResponseEntity<List<Champion>> searchChampions(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of Champions for query {}", query);
        Page<Champion> page = championService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
}

package com.krista.repository.search;

import com.krista.domain.Champion;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the {@link Champion} entity.
 */
public interface ChampionSearchRepository extends ElasticsearchRepository<Champion, Long> {
}

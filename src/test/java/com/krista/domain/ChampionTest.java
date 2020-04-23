package com.krista.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.krista.web.rest.TestUtil;

public class ChampionTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Champion.class);
        Champion champion1 = new Champion();
        champion1.setId(1L);
        Champion champion2 = new Champion();
        champion2.setId(champion1.getId());
        assertThat(champion1).isEqualTo(champion2);
        champion2.setId(2L);
        assertThat(champion1).isNotEqualTo(champion2);
        champion1.setId(null);
        assertThat(champion1).isNotEqualTo(champion2);
    }
}

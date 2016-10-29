package org.jjfflyboy.mpc4j;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class PlChangesPosIdTest {

    @Test
    public void response() {
        String[] lines = new String [] {
                "cpos: 1",
                "Id: 2",
                "cpos: 2",
                "Id: 3",
                "cpos: 3",
                "Id: 4",
                "OK"
        };

        PlChangesPosId.Response r = new PlChangesPosId(3).response(lines);
        assertThat(r.getEntries().size()).isEqualTo(3);
        assertThat(r.getEntries().get(2).getCpos().get()).isEqualTo(3);
        assertThat(r.getEntries().get(2).getId().get()).isEqualTo(4);
    }
}

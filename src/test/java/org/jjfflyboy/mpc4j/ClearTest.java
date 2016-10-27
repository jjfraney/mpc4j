package org.jjfflyboy.mpc4j;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class ClearTest {

    @Test
    public void command() {
        String text = new Clear().text();
        assertThat(text).isEqualTo("clear");
    }
}

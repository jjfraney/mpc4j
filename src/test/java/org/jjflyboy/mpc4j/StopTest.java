package org.jjflyboy.mpc4j;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class StopTest {

    @Test
    public void text() {
        assertThat(new Stop().text()).as("wrong command").isEqualTo("stop");
    }

}
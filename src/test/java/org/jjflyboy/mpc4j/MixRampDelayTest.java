package org.jjflyboy.mpc4j;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jfraney
 */
public class MixRampDelayTest {
    @Test
    public void text() {
        assertThat(new MixRampDelay(10).text()).as("wrong command").isEqualTo("mixrampdelay 10");
    }
    @Test
    public void textNan() {
        assertThat(new MixRampDelay().text()).as("wrong command").isEqualTo("mixrampdelay nan");
    }
}
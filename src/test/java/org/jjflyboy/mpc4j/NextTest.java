package org.jjflyboy.mpc4j;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jfraney
 */
public class NextTest {

    @Test
    public void text() {
        assertThat(new Next().text()).as("wrong command").isEqualTo("next");
    }

}
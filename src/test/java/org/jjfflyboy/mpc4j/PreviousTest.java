package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class PreviousTest {

    @Test
    public void text() {
        assertThat(new Previous().text()).as("wrong command").isEqualTo("previous");
    }

}
package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class ClearErrorTest {

    @Test
    public void text() {
        assertThat(new ClearError().text()).as("wrong command").isEqualTo("clearerror");
    }

}
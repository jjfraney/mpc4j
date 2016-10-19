package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jfraney
 */
public class ReplayGainModeTest {
    @Test
    public void text() {
        assertThat(new ReplayGainMode(ReplayGainMode.Mode.AUTO).text()).as("wrong command").isEqualTo("replay_gain_mode auto");
    }
}
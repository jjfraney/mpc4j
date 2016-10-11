package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jfraney
 */
public class ReplayGainModeTest {
    @Test
    public void text() {
        Assert.assertEquals("wrong command", "replay_gain_mode auto", new ReplayGainMode(ReplayGainMode.Mode.AUTO).text());
    }
}
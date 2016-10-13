package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jfraney
 */
public class PlayIdTest {

    @Test
    public void textDefault() {
        Assert.assertEquals("wrong command", "playid", new PlayId().text());
    }
    @Test
    public void textSongPos() {
        Assert.assertEquals("wrong command", "playid 10", new PlayId(10).text());
    }
}
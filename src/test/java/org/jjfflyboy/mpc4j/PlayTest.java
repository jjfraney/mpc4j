package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jfraney
 */
public class PlayTest {

    @Test
    public void textDefault() {
        Assert.assertEquals("wrong command", "play", new Play().text());
    }
    @Test
    public void textSongPos() {
        Assert.assertEquals("wrong command", "play 10", new Play(10).text());
    }
}
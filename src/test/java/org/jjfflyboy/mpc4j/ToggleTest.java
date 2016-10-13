package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Test;

import static org.jjfflyboy.mpc4j.Toggle.OFF;
import static org.jjfflyboy.mpc4j.Toggle.ON;
import static org.junit.Assert.*;

/**
 * @author jfraney
 */
public class ToggleTest {
    @Test
    public void random() {
        Assert.assertEquals("wrong command", "random 0", new Random(OFF).text());
    }
    @Test
    public void repeat() {
        Assert.assertEquals("wrong command", "repeat 1", new Repeat(ON).text());
    }
    @Test
    public void single() {
        Assert.assertEquals("wrong command", "single 1", new Single(ON).text());
    }
    @Test
    public void pause() {
        Assert.assertEquals("wrong command", "pause 1", new Pause(ON).text());
    }
}
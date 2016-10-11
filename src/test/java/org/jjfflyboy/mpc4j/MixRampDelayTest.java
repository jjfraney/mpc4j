package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jfraney
 */
public class MixRampDelayTest {
    @Test
    public void text() {
        Assert.assertEquals("wrong command", "mixrampdelay 10", new MixRampDelay(10).text());
    }
    @Test
    public void textNan() {
        Assert.assertEquals("wrong command", "mixrampdelay nan", new MixRampDelay().text());
    }
}
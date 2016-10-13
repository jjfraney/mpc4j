package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author jfraney
 */
public class SeekIdTest {

    @Test
    public void textBigDecimal() {
        Assert.assertEquals("wrong command", "seekid 10 30.3", new SeekId(10, new BigDecimal("30.3")).text());
    }
    @Test
    public void textInteger() {
        Assert.assertEquals("wrong command", "seekid 10 20", new SeekId(10, Integer.valueOf(20)).text());
    }
    @Test
    public void textFloat() {
        Assert.assertEquals("wrong command", "seekid 10 1.2", new SeekId(10, Float.valueOf("1.2")).text());
    }
}
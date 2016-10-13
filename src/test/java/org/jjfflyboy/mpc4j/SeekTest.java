package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author jfraney
 */
public class SeekTest {

    @Test
    public void textBigDecimal() {
        Assert.assertEquals("wrong command", "seek 10 30.3", new Seek(10, new BigDecimal("30.3")).text());
    }
    @Test
    public void textInteger() {
        Assert.assertEquals("wrong command", "seek 10 20", new Seek(10, Integer.valueOf(20)).text());
    }
    @Test
    public void textFloat() {
        Assert.assertEquals("wrong command", "seek 10 1.2", new Seek(10, Float.valueOf("1.2")).text());
    }
}
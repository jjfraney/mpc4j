package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author jfraney
 */
public class SeekCurTest {

    @Test
    public void textBigDecimal() {
        Assert.assertEquals("wrong command", "seekcur 30.3", new SeekCur(new BigDecimal("30.3")).text());
    }
    @Test
    public void textInteger() {
        Assert.assertEquals("wrong command", "seekcur 20", new SeekCur(Integer.valueOf(20)).text());
    }
    @Test
    public void textFloat() {
        Assert.assertEquals("wrong command", "seekcur 1.2", new SeekCur(Float.valueOf("1.2")).text());
    }
}
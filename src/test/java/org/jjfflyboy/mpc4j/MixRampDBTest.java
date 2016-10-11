package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author jfraney
 */
public class MixRampDBTest {
    @Test
    public void text() {
        Assert.assertEquals("wrong command", "mixrampdb 3.1", new MixRampDB(new BigDecimal("3.1")).text());
    }
}
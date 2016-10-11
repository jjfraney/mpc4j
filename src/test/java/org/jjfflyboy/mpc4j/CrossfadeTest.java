package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jfraney
 */
public class CrossfadeTest {
    @Test
    public void textDefault() {
        Assert.assertEquals("wrong text", "crossfade 0", new Crossfade().text());
    }
    @Test
    public void textByTen() {
        Assert.assertEquals("wrong text", "crossfade 10", new Crossfade(10).text());
    }

}
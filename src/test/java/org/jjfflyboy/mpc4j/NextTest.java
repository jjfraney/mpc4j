package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jfraney
 */
public class NextTest {

    @Test
    public void text() {
        Assert.assertEquals("wrong command", "next", new Next().text());
    }

}
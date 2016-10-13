package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jfraney
 */
public class StopTest {

    @Test
    public void text() {
        Assert.assertEquals("wrong command", "stop", new Stop().text());
    }

}
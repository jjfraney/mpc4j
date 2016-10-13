package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jfraney
 */
public class ClearErrorTest {

    @Test
    public void text() {
        Assert.assertEquals("wrong command", "clearerror", new ClearError().text());
    }

}
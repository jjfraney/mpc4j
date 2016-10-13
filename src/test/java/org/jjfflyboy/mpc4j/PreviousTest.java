package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jfraney
 */
public class PreviousTest {

    @Test
    public void text() {
        Assert.assertEquals("wrong command", "previous", new Previous().text());
    }

}
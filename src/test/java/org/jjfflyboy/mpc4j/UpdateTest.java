package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jfraney
 */
public class UpdateTest {
    @Test
    public void text() {
        Update command = new Update();
        Assert.assertEquals("wrong command", "update", command.text());
    }
}
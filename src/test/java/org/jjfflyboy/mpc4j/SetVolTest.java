package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jfraney
 */
public class SetVolTest {

    @Test
    public void text() throws Exception {
        SetVol command = new SetVol(20);
        Assert.assertEquals("wrong command", "setvol 20", command.text());
    }
}
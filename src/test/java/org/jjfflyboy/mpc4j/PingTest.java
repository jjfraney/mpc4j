package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jfraney
 */
public class PingTest {
    Ping command;
    @Before
    public void setUp()  {
        command = new Ping();
    }

    @Test
    public void text() {
        Assert.assertEquals("not a ping command", "ping", command.text());
    }

    @Test
    public void response() {
        String [] textResponse = new String[] {"OK"};
        Ping.Response response = command.response(textResponse);
        Assert.assertTrue("response could not parse \"OK\"", response.isOk());
    }
}
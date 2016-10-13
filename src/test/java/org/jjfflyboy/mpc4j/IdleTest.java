package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author jfraney
 */
public class IdleTest {
    Idle command;
    @Before
    public void setUp()  {
        command = new Idle();
    }

    @Test
    public void text() {
        Assert.assertEquals("wrong command", "idle", command.text());
    }

    @Test
    public void response() {
        String [] textResponse = new String[] {"changed: options", "OK"};
        Idle.Response response = command.response(textResponse);
        Assert.assertEquals("response could not parse \"changed\"", Idle.Subsystem.OPTIONS, response.getChanged().get());
    }
}
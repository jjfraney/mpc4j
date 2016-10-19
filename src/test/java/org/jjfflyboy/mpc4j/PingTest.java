package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

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
        assertThat(command.text()).as("not a ping command").isEqualTo("ping");
    }

    @Test
    public void response() {
        String [] textResponse = new String[] {"OK"};
        Ping.Response response = command.response(textResponse);
        assertThat(response.isOk()).as("response could not parse \"OK\"").isTrue();
    }
}
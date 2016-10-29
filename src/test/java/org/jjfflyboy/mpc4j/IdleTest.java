package org.jjfflyboy.mpc4j;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(command.text()).as("wrong command").isEqualTo("idle");
    }

    @Test
    public void textWithMultipleSubsystems() {
        String text = new Idle(Idle.Subsystem.MIXER, Idle.Subsystem.OPTIONS, Idle.Subsystem.DATABASE).text();
        assertThat(text).isEqualTo("idle mixer options database");
    }

    @Test
    public void response() {
        String [] textResponse = new String[] {"changed: options", "OK"};
        Idle.Response response = command.response(textResponse);
        assertThat(response.getChanged().get()).as("response could not parse \"changed\"").isEqualTo(Idle.Subsystem.OPTIONS);
    }
}
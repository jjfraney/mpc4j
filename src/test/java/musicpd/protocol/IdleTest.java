package musicpd.protocol;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

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
        final String text = new Idle(Idle.Subsystem.MIXER, Idle.Subsystem.OPTIONS, Idle.Subsystem.DATABASE).text();
        assertThat(text).isEqualTo("idle mixer options database");
    }

    @Test
    public void response() {
        final java.util.List<String> textResponse = Arrays.asList("changed: options", "OK");
        final Idle.Response response = command.response(textResponse, "OK MPD 0.19.0");
        assertThat(response.getChanged().orElse(null)).as("response could not parse \"changed\"").isEqualTo(Idle.Subsystem.OPTIONS);
    }
}
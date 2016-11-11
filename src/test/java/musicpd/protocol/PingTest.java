package musicpd.protocol;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

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
        java.util.List<String> textResponse = Arrays.asList("OK");
        SimpleResponse response = command.response(textResponse);
        assertThat(response.isOk()).as("response could not parse \"OK\"").isTrue();
    }
}
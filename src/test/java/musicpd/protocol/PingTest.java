package musicpd.protocol;

import com.github.jjfraney.mpc.SimpleResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
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
        final java.util.List<String> textResponse = Collections.singletonList("OK");
        final SimpleResponse response = command.response(textResponse, "OK MPD 0.19.0");
        assertThat(response.isOk()).as("response could not parse \"OK\"").isTrue();
    }
}
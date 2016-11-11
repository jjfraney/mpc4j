package musicpd.protocol;

import org.junit.Test;

import static musicpd.protocol.Toggle.OFF;
import static musicpd.protocol.Toggle.ON;
import static org.assertj.core.api.Assertions.*;

/**
 * @author jfraney
 */
public class ToggleTest {
    @Test
    public void random() {
        assertThat(new Random(OFF).text()).as("wrong command").isEqualTo("random 0");
    }
    @Test
    public void repeat() {
        assertThat(new Repeat(ON).text()).as("wrong command").isEqualTo("repeat 1");
    }
    @Test
    public void single() {
        assertThat(new Single(ON).text()).as("wrong command").isEqualTo("single 1");
    }
    @Test
    public void pause() {
        assertThat(new Pause(ON).text()).as("wrong command").isEqualTo("pause 1");
    }
}
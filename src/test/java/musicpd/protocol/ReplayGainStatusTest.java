package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jfraney
 */
public class ReplayGainStatusTest {
    @Test
    public void text() {
        assertThat(new ReplayGainStatus().text()).as("wrong command").isEqualTo("replay_gain_status");
    }
}
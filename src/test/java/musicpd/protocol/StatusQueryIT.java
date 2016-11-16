package musicpd.protocol;

import org.jjflyboy.mpc.MPC;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <p>
 *     Requires an mpd server, running on localhsot:6600.  See mpc4j/docker/mpd.
 * </p>
 * @author jfraney
 */
public class StatusQueryIT {

    private MPC mpc;
    @Before
    public void before() {
        mpc = new MPC();
    }
    @Test
    public void testStatus() throws IOException {
        final Status command = new Status();
        final Status.Response r = mpc.send(command);
        assertThat(r.isOk()).as("command status").isTrue();
        assertThat(r.getProtocolVersion().orElse(null)).as("version").isEqualTo("0.19.0");
        assertThat(r.getRandom()).as("response value").isPresent();
        assertThat(r.getXfade()).as("response value").isNotPresent();
    }

    @Test
    public void testStats() throws IOException {
        final Stats command = new Stats();
        final Stats.Response r = mpc.send(command);
        assertThat(r.isOk()).as("command status").isTrue();
    }
}

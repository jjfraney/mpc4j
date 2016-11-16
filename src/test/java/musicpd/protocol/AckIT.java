package musicpd.protocol;

import com.github.jjfraney.mpc.Command;
import com.github.jjfraney.mpc.MPC;
import com.github.jjfraney.mpc.SimpleResponse;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests the playback control type commands
 * <p>
 *     Requires an mpd server, running on localhsot:6600.  See mpc4j/docker/mpd.
 * </p>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class AckIT {
    private MPC mpc;
    @Before
    public void before() {
        mpc = new MPC();
    }

    private class BadCommand extends Simple {

        @Override
        public String text() {
            return "find";
        }
    }
    @Test
    public void testBadCommand() throws IOException {
        final SimpleResponse r = mpc.send(new BadCommand());
        assertThat(r.getAck()).as("ack should be response").isPresent();

        assertThat(r.getResponseLines().get(0)).isEqualTo("ACK [2@0] {find} too few arguments for \"find\"");
        final Command.Response.Ack ack = r.getAck().orElse(null);
        assertThat(ack.getError()).as("error number should show bad find").isEqualTo(2);
    }

}

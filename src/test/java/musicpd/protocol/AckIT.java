package musicpd.protocol;

import org.jjflyboy.mpc.MPC;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests the playback control type commands
 * <p>
 *     Requires an mpd server, running on localhsot:6600.  See mpc4j/docker/mpd.
 * </p>
 * @author jfraney
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
        SimpleResponse r = mpc.send(new BadCommand());
        assertThat(r.isOk()).as("bad command should fail").isEqualTo(false);
        assertThat(r.getAck()).as("ack should be response").isPresent();

        assertThat(r.getResponseLines().get(0)).isEqualTo("ACK [2@0] {find} too few arguments for \"find\"");
        Command.Response.Ack ack = r.getAck().get();
        assertThat(ack.getError()).as("error number should show bad find").isEqualTo(2);
        assertThat(ack.getCurrentCommand()).as("command should be 'find'.").isEqualTo("find");
        assertThat(ack.getMessageText()).as("argument count error").isEqualTo("too few arguments for \"find\"");
    }

}

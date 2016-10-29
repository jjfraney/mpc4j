package org.jjfflyboy.mpc4j;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests the playback control type commands
 * @author jfraney
 */
@RunWith(Arquillian.class)
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
    @RunAsClient
    public void testBadCommand() throws IOException {
        SimpleResponse r = mpc.send(new BadCommand());
        assertThat(r.isOk()).as("bad command should fail").isEqualTo(false);
        assertThat(r.getAck()).as("ack should be response").isPresent();

        assertThat(r.getResponseLines()[0]).isEqualTo("ACK [2@0] {find} too few arguments for \"find\"");
        Command.Response.Ack ack = r.getAck().get();
        assertThat(ack.getError()).as("error number should show bad find").isEqualTo(2);
        assertThat(ack.getCurrentCommand()).as("command should be 'find'.").isEqualTo("find");
        assertThat(ack.getMessageText()).as("argument count error").isEqualTo("too few arguments for \"find\"");
    }

}

package musicpd.protocol;

import com.github.jjfraney.mpc.Command;
import com.github.jjfraney.mpc.SimpleResponse;
import org.junit.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class AckTest {

    @Test
    public void ackParse() {
        final java.util.List<String> response = Collections.singletonList(
                "ACK [5@0] {cmd01} missing the command."
        );
        final Command.Response.Ack ack = new SimpleResponse(response, "OK MPD 0.19.0").getAck().orElse(null);
        assertThat(ack.getError()).as("error num").isEqualTo(5);
        assertThat(ack.getCommandListNum()).as("command list num").isEqualTo(0);
        assertThat(ack.getCurrentCommand()).as("current command").isEqualTo("cmd01");
        assertThat(ack.getMessageText()).as("message text").isEqualTo("missing the command.");
    }
}

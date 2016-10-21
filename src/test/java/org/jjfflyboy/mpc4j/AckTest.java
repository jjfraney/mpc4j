package org.jjfflyboy.mpc4j;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class AckTest {

    @Test
    public void c1() {
        String line = "ACK [5@0] {cmd01} missing the command.";
        ResponseContent.AckImpl ack = new ResponseContent.AckImpl(line);
        assertThat(ack.getError()).as("error num").isEqualTo(5);
        assertThat(ack.getCommandListNum()).as("command list num").isEqualTo(0);
        assertThat(ack.getCurrentCommand()).as("current command").isEqualTo("cmd01");
        assertThat(ack.getMessageText()).as("message text").isEqualTo("missing the command.");
    }
}

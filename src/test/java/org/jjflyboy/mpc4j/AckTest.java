package org.jjflyboy.mpc4j;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class AckTest {

    @Test
    public void ackParse() {
        java.util.List<String> response = Arrays.asList(
                "ACK [5@0] {cmd01} missing the command."
        );
        Command.Response.Ack ack = new SimpleResponse(response).getAck().get();
        assertThat(ack.getError()).as("error num").isEqualTo(5);
        assertThat(ack.getCommandListNum()).as("command list num").isEqualTo(0);
        assertThat(ack.getCurrentCommand()).as("current command").isEqualTo("cmd01");
        assertThat(ack.getMessageText()).as("message text").isEqualTo("missing the command.");
    }
}

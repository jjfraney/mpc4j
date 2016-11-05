package org.jjfflyboy.mpc4j;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class CommandsTest {

    @Test
    public void commands() {
        Commands.Response r = new Commands().response(Arrays.asList(
                "command: add",
                "command: addid",
                "command: addtagid",
                "OK"
        ));
        java.util.List<String> commands = r.getCommands();
        assertThat(commands.size()).isEqualTo(3);
        assertThat(commands.get(2)).isEqualTo("addtagid");
    }
}

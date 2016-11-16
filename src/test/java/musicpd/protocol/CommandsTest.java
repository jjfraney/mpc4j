package musicpd.protocol;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class CommandsTest {

    @Test
    public void commands() {
        final Commands.Response r = new Commands().response(Arrays.asList(
                "command: add",
                "command: addid",
                "command: addtagid",
                "OK"
        ), "OK MPD 0.19.0");
        final java.util.List<String> commands = r.getCommands();
        assertThat(commands.size()).isEqualTo(3);
        assertThat(commands.get(2)).isEqualTo("addtagid");
    }
}

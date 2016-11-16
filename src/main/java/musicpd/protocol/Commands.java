package musicpd.protocol;

import org.jjflyboy.mpc.AbstractCommand;
import org.jjflyboy.mpc.HealthResponse;

/**
 * commands command
 * from <a href='https://www.musicpd.org/doc/protocol/reflection_commands.html'>
 *     MPD document: Reflection</a>
 * <p>
 *     The response of this command is list of strings (allowed commands).
 * </p>
 * @author jfraney
 */

public class Commands extends AbstractCommand<Commands.Response> {

    /**
     * response to commands
     */
    public static class Response extends HealthResponse {
        Response(final java.util.List<String> responseLines, final String connectResponse) {
            super(responseLines, connectResponse);
        }

        public java.util.List<String> getCommands() {
            return getListOfStringValue("command");
        }
    }

    /**
     *
     * @param responseLines given by mpd server in response to this command.
     * @param connectResponse of the MPD source of the response.
     * @return commands response
     */
    @Override
    public Response response(final java.util.List<String> responseLines, final String connectResponse) {
        return new Response(responseLines, connectResponse);
    }
}

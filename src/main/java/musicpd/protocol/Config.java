package musicpd.protocol;

import org.jjflyboy.mpc.AbstractCommand;
import org.jjflyboy.mpc.HealthResponse;

import java.util.Optional;

/**
 * config command
 * from <a href='https://www.musicpd.org/doc/protocol/reflection_commands.html'>
 *     MPD document: Reflection</a>
 * @author jfraney
 */

public class Config extends AbstractCommand<Config.Response> {

    /**
     * response to config
     */
    public static class Response extends HealthResponse {
        Response(final java.util.List<String> responseLines, final String connectResponse) {
            super(responseLines, connectResponse);
        }

        /**
         * get the value of the 'music_directory' response line.
         * @return
         */
        public Optional<String> getMusicDirectory() {
            return getStringValue("music_directory");
        }

    }

    /**
     * @param responseLines given by mpd server in response to this command.
     * @param connectResponse of the MPD source of the response.
     * @return response to the config
     */
    @Override
    public Response response(final java.util.List<String> responseLines, final String connectResponse) {
        return new Response(responseLines, connectResponse);
    }
}

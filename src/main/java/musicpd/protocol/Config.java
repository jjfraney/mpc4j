package musicpd.protocol;

import org.jjflyboy.mpc.AbstractCommand;
import org.jjflyboy.mpc.HealthResponse;

import java.util.Optional;

/**
 * config command
 * from <a href='https://www.musicpd.org/doc/protocol/reflection_commands.html'>MPD document: Reflection</a>
 * @Author jfraney
 */

public class Config extends AbstractCommand<Config.Response> {

    public Config() {
        super();
    }

    public static class Response extends HealthResponse {
        Response(java.util.List<String> responseLines, String connectResponse) {
            super(responseLines, connectResponse);
        }

        public Optional<String> getMusicDirectory() {
            return getStringValue("music_directory");
        }

    }

    @Override
    public Response response(java.util.List<String> responseLines, String connectResponse) {
        return new Response(responseLines, connectResponse);
    }
}

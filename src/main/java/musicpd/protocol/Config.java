package musicpd.protocol;

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
        Response(java.util.List<String> responseLines) {
            super(responseLines);
        }

        public Optional<String> getMusicDirectory() {
            return getStringValue("music_directory");
        }

    }

    @Override
    public Response response(java.util.List<String> responseLines) {
        return new Response(responseLines);
    }
}

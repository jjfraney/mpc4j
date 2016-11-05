package org.jjfflyboy.mpc4j;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * config command
 * from <a href='https://www.musicpd.org/doc/protocol/reflection_commands.html'>MPD document: Reflection</a>
 * @Author jfraney
 */

public class Config extends AbstractCommand<Config.Response> {

    public Config() {
        super();
    }

    public static class Response extends SimpleResponse {
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

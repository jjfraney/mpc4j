package musicpd.protocol;

import java.util.stream.Collectors;

/**
 * urlhandlers command
 * from <a href='https://www.musicpd.org/doc/protocol/reflection_commands.html'>MPD document: Reflection</a>
 * @Author jfraney
 */

public class UrlHandlers extends AbstractCommand<UrlHandlers.Response> {

    public UrlHandlers() {
        super();
    }

    public static class Response extends SimpleResponse {
        Response(java.util.List<String> responseLines) {
            super(responseLines);
        }

        public java.util.List<String> getHandlers() {
            return getResponseLines().stream()
                    .filter(l -> l.startsWith("handler: "))
                    .map(l -> l.split(": "))
                    .filter(s -> s.length == 2)
                    .map(s -> s[1])
                    .collect(Collectors.toList());
        }
    }

    @Override
    public Response response(java.util.List<String> responseLines) {
        return new Response(responseLines);
    }
}

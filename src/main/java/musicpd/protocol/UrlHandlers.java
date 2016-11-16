package musicpd.protocol;

import com.github.jjfraney.mpc.AbstractCommand;
import com.github.jjfraney.mpc.HealthResponse;

import java.util.stream.Collectors;

/**
 * urlhandlers command
 * from <a href='https://www.musicpd.org/doc/protocol/reflection_commands.html'>
 *     MPD document: Reflection</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */

public class UrlHandlers extends AbstractCommand<UrlHandlers.Response> {

    public static class Response extends HealthResponse {
        Response(final java.util.List<String> responseLines, final String connectResponse) {
            super(responseLines, connectResponse);
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
    public Response response(final java.util.List<String> responseLines, final String connectResponse) {
        return new Response(responseLines, connectResponse);
    }
}

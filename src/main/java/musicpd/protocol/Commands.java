package musicpd.protocol;

/**
 * commands command
 * from <a href='https://www.musicpd.org/doc/protocol/reflection_commands.html'>MPD document: Reflection</a>
 * <p>
 *     The response of this command is list of strings (allowed commands).
 * </p>
 * @Author jfraney
 */

public class Commands extends AbstractCommand<Commands.Response> {

    public Commands() {
        super();
    }

    public static class Response extends HealthResponse {
        Response(java.util.List<String> responseLines) {
            super(responseLines);
        }

        public java.util.List<String> getCommands() {
            return getListOfStringValue("command");
        }
    }

    @Override
    public Response response(java.util.List<String> responseLines) {
        return new Response(responseLines);
    }
}

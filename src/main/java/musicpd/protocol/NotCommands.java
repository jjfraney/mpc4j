package musicpd.protocol;

import org.jjflyboy.mpc.AbstractCommand;

/**
 * notcommands command
 * from <a href='https://www.musicpd.org/doc/protocol/reflection_commands.html'>MPD document: Reflection</a>
 * <p>
 *     The response of this command is list of strings (disallowed commands).
 * </p>
 * @Author jfraney
 */

public class NotCommands extends AbstractCommand<Commands.Response> {

    public NotCommands() {
        super();
    }

    @Override
    public Commands.Response response(java.util.List<String> responseLines, String connectResponse) {
        return new Commands.Response(responseLines, connectResponse);
    }
}

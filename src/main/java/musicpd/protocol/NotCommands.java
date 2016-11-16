package musicpd.protocol;

import com.github.jjfraney.mpc.AbstractCommand;

/**
 * notcommands command
 * from <a href='https://www.musicpd.org/doc/protocol/reflection_commands.html'>
 *     MPD document: Reflection</a>
 * <p>
 *     The response of this command is list of strings (disallowed commands).
 * </p>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */

public class NotCommands extends AbstractCommand<Commands.Response> {

    @Override
    public Commands.Response response(final java.util.List<String> responseLines, final String connectResponse) {
        return new Commands.Response(responseLines, connectResponse);
    }
}

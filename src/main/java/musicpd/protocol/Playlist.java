package musicpd.protocol;

import com.github.jjfraney.mpc.AbstractCommand;
import com.github.jjfraney.mpc.Command;
import com.github.jjfraney.mpc.MpcRuntimeException;

import java.util.List;

/**
 * playlist command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>
 *     MPD Document: The current playlist.</a>
 * <p>
 *     MPD documentation advises against using this command.
 *     This command is intentionally inoperable.
 *     This class serves as placeholder to document such.
 * </p>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class Playlist extends AbstractCommand<Command.Response> {

    /**
     * MPD documents advises against using this command.
     * No implementation is provided.
     */
    private Playlist() {
        throw new MpcRuntimeException("Do not use.");
    }

    @Override
    public String text() {
        throw new MpcRuntimeException("Do not use.");
    }

    @Override
    public Response response(final List<String> responseLines, final String connectResponse) {
        return null;
    }
}

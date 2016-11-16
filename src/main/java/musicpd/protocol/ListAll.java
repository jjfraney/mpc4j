package musicpd.protocol;

import org.jjflyboy.mpc.AbstractCommand;
import org.jjflyboy.mpc.Command;
import org.jjflyboy.mpc.MpcRuntimeException;

import java.util.List;

/**
 * listall command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>
 *     MPD Document: The music database.</a>
 * <p>
 *     MPD documentation advises against using this command.
 *     This command is intentionally inoperable.
 *     This class serves as placeholder to document such.
 * </p>
 * @author jfraney
 */
public class ListAll extends AbstractCommand<Command.Response> {

    /**
     * MPD documents advises against using this command.  No implementation is provided.
     */
    private ListAll() {
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

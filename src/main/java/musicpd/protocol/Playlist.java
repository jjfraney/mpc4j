package musicpd.protocol;

import java.util.List;

/**
 * playlist command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * <p>
 *     MPD documentation advises against using this command.
 *     This command is intentionally inoperable.
 *     This class serves as placeholder to document such.
 * </p>
 * @author jfraney
 */
public class Playlist extends AbstractCommand<Command.Response> {

    /**
     * MPD documents advises against using this command.  No implementation is provided.
     */
    private Playlist() {
        throw new RuntimeException("Do not use.");
    }

    @Override
    public String text() {
        throw new RuntimeException("Do not use.");
    }

    @Override
    public Response response(List<String> responseLines) {
        return null;
    }
}

package musicpd.protocol;

/**
 * add command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>
 *     MPD Document: The current playlist.
 * </a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class Add extends Simple {
    /**
     * @param uri song file location
     */
    public Add(final String uri) {
        super(adapt(uri));
    }
}

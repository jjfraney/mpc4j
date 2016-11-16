package musicpd.protocol;

/**
 * rescan command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>
 *     MPD Document: The music database.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class Rescan extends Simple {
    public Rescan() {
        super();
    }
    public Rescan(final String uri) {
        super(adapt(uri));
    }
}

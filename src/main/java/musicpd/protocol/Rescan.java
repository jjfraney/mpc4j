package musicpd.protocol;

/**
 * rescan command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>
 *     MPD Document: The music database.</a>
 * @author jfraney
 */
public class Rescan extends Simple {
    public Rescan() {
        super();
    }
    public Rescan(final String uri) {
        super(adapt(uri));
    }
}

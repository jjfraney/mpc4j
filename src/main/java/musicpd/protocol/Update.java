package musicpd.protocol;

/**
 * update command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>
 *     MPD Document: The music database.</a>
 * @author jfraney
 */
public class Update extends Simple {
    public Update() {
        super();
    }
    public Update(final String uri) {
        super(adapt(uri));
    }
}

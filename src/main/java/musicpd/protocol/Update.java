package musicpd.protocol;

/**
 * update command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>
 *     MPD Document: The music database.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class Update extends Simple {
    public Update() {
        super();
    }
    public Update(final String uri) {
        super(adapt(uri));
    }
}

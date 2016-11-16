package musicpd.protocol;

/**
 * readcomments command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>
 *     MPD Document: The music database.</a>
 * <p>
 *     On this command, mpd returns a list of arbitrary name-values.
 *     Use Response.getResponseLines() to access them.
 * </p>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class ReadComments extends Simple {
    /**
     * @param uri of song
     */
    public ReadComments(final String uri) {
        super(adapt(uri));
    }

}

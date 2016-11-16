package musicpd.protocol;

/**
 * rm command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>
 *     MPD Document: Stored playlists.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class Rm extends Simple {
    /**
     * @param name of playlist
     */
    public Rm(final String name) {
        super(adapt(name));
    }
}

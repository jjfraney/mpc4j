package musicpd.protocol;

/**
 * playlistadd command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>
 *     MPD Document: Stored playlists.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class PlaylistAdd extends Simple {
    /**
     * @param name of playlist
     * @param uri of song
     */
    public PlaylistAdd(final String name, final String uri) {
        super(adapt(name), adapt(uri));
    }
}

package musicpd.protocol;

/**
 * playlistclear command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>
 *     MPD Document: Stored playlists.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class PlaylistClear extends Simple {
    /**
     * @param name of playlist
     */
    public PlaylistClear(final String name) {
        super(adapt(name));
    }
}

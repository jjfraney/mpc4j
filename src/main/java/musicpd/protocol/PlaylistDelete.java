package musicpd.protocol;

/**
 * playlistdelete command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>
 *     MPD Document: Stored playlists.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class PlaylistDelete extends Simple {
    /**
     * @param name of playlist
     * @param songPos of song to delete
     */
    public PlaylistDelete(final String name, final Integer songPos) {
        super(adapt(name), adapt(songPos));
    }
}

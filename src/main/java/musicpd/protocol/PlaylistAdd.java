package musicpd.protocol;

/**
 * playlistadd command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>
 *     MPD Document: Stored playlists.</a>
 * @author jfraney
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

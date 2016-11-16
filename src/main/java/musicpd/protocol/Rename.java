package musicpd.protocol;

/**
 * rename command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>
 *     MPD Document: Stored playlists.</a>
 * @author jfraney
 */
public class Rename extends Simple {
    /**
     * @param name of playlist
     * @param newName of playlist
     */
    public Rename(final String name, final String newName) {
        super(adapt(name), adapt(newName));
    }
}

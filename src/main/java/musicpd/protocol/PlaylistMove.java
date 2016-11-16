package musicpd.protocol;

import org.jjflyboy.mpc.RangeParameter;

/**
 * playlistmove command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>
 *     MPD Document: Stored playlists.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class PlaylistMove extends Simple {
    /**
     * @param name of playlist
     * @param from current position
     * @param to new position
     */
    public PlaylistMove(final String name, final Integer from, final Integer to) {
        super(adapt(name), new RangeParameter(from, to));
    }
}

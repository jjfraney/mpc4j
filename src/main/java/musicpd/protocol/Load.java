package musicpd.protocol;

import org.jjflyboy.mpc.RangeParameter;

/**
 * load command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>
 *     MPD Document: Stored playlists.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class Load extends Simple {
    /**
     * @param name of playlist
     */
    public Load(final String name) {
        super(adapt(name));
    }

    /**
     * @param name of playlist
     * @param start position of first song in range to load
     * @param end position of last song in range to load
     */
    public Load(final String name, final Integer start, final Integer end) {
        super(adapt(name), new RangeParameter(start, end));
    }
}

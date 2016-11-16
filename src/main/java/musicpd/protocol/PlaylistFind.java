package musicpd.protocol;

import org.jjflyboy.mpc.FilterParameter;
import org.jjflyboy.mpc.QueueQuery;

/**
 * playlistfind command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>
 *     MPD Document: The current playlist.</a>
 * <p>
 *     This command's response contains metadata of a queued song.
 * </p>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class PlaylistFind extends QueueQuery {

    /**
     * @param tag of songs to return in result
     * @param needle (or value) of the tag of songs to return in result
     * @see musicpd.protocol.Tag
     */
    public PlaylistFind(final Tag tag, final String needle) {
        super(new FilterParameter(tag, needle));
    }

}

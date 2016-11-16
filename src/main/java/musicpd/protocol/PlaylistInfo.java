package musicpd.protocol;

import org.jjflyboy.mpc.QueueQuery;
import org.jjflyboy.mpc.RangeParameter;

/**
 * playlistinfo command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>
 *     MPD Document: The current playlist.</a>
 * <p>
 *     This command's response contains metadata of a queued song.
 * </p>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class PlaylistInfo extends QueueQuery {
    /**
     * @param songpos position of songs of interest
     */
    public PlaylistInfo(final Integer ... songpos) {super(adapt(songpos));}

    /**
     * @param start position of range of songs of interest
     * @param end position of range of songs of interest
     */
    public PlaylistInfo(final Integer start, final Integer end) {super(new RangeParameter(start, end));}

}

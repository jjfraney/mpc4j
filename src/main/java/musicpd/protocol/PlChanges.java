package musicpd.protocol;

import org.jjflyboy.mpc.QueueQuery;

/**
 * plchanges command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * <p>
 *     This command's response contains metadata of a queued song.
 * </p>
 * @author jfraney
 */
public class PlChanges extends QueueQuery {
    /**
     * @param version to compare changes
     */
    public PlChanges(Integer version) {
        super(adapt(version));
    }

}

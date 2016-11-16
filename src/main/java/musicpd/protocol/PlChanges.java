package musicpd.protocol;

import com.github.jjfraney.mpc.QueueQuery;

/**
 * plchanges command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>
 *     MPD Document: The current playlist.</a>
 * <p>
 *     This command's response contains metadata of a queued song.
 * </p>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class PlChanges extends QueueQuery {
    /**
     * @param version to compare changes
     */
    public PlChanges(final Integer version) {
        super(adapt(version));
    }

}

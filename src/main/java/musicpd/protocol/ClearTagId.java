package musicpd.protocol;

/**
 * cleartagid command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>
 *     MPD Document: The current playlist.</a>
 * @author jfraney
 */
public class ClearTagId extends Simple {
    /**
     * @param songId id of target song in the queue
     * @param tag legal tag
     */
    public ClearTagId(final Integer songId, final Tag tag) {
        super(adapt(songId), tag);
    }
}

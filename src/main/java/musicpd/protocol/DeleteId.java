package musicpd.protocol;

/**
 * deleteid command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>
 *     MPD Document: The current playlist.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class DeleteId extends Simple {
    /**
     * deletes a song from the queue
     * @param songId of song to delete.
     */
    public DeleteId(final Integer songId) {
        super(adapt(songId));
    }
}

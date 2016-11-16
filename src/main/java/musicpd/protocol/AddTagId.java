package musicpd.protocol;

/**
 * addtagid command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>
 *     MPD Document: The current playlist.
 * </a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class AddTagId extends Simple {
    /**
     * @param songId id of target song in the queue
     * @param tag legal tag
     * @param value of tag
     */
    public AddTagId(final Integer songId, final Tag tag, final String value) {
        super(adapt(songId), tag, adapt(value));
    }
}

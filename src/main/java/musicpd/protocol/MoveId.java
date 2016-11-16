package musicpd.protocol;

/**
 * moveid command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>
 *     MPD Document: The current playlist.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class MoveId extends Simple {
    /**
     * @param songId of song to move
     * @param to new position of the song
     */
    public MoveId(final Integer songId, final Integer to) {
        super(adapt(songId), adapt(to));
    }
}

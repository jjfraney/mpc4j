package musicpd.protocol;

/**
 * swap command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>
 *     MPD Document: The current playlist.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class Swap extends Simple {
    /**
     * @param position1 of one selected song
     * @param position2 of the other selected song
     */
    public Swap(final Integer position1, final Integer position2) {
        super(adapt(position1), adapt(position2));
    }
}

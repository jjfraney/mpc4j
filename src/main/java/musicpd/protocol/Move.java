package musicpd.protocol;

import com.github.jjfraney.mpc.RangeParameter;

/**
 * move command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class Move extends Simple {

    /**
     * @param from current position of song
     * @param to new position of song
     */
    public Move(final Integer from, final Integer to) {
        super(adapt(from), adapt(to));
    }

    /**
     * @param start first position of range of songs
     * @param end last position of range of songs
     * @param to new position of the above range of songs
     */
    public Move(final Integer start, final Integer end, final Integer to) {
        super(new RangeParameter(start, end), adapt(to));
    }
}

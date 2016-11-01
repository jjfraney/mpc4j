package org.jjfflyboy.mpc4j;

/**
 * move command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * @author jfraney
 */
public class Move extends Simple {

    /**
     * @param from current position of song
     * @param to new position of song
     */
    public Move(Integer from, Integer to) {
        super(adapt(from), adapt(to));
    }

    /**
     * @param start first position of range of songs
     * @param end last position of range of songs
     * @param to new position of the above range of songs
     */
    public Move(Integer start, Integer end, Integer to) {
        super(new RangeParameter(start, end), adapt(to));
    }
}

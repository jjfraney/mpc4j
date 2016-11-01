package org.jjfflyboy.mpc4j;

/**
 * move command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * @author jfraney
 */
public class Move extends Simple {

    public Move(Integer from, Integer to) {
        super(adapt(from), adapt(to));
    }
    public Move(Integer start, Integer end, Integer to) {
        super(new RangeParameter(start, end), adapt(to));
    }
}

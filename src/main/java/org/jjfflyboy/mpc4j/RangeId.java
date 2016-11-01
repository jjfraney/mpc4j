package org.jjfflyboy.mpc4j;

/**
 * rangeid command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * @author jfraney
 */
public class RangeId extends Simple {
    public RangeId(Integer id, Integer start, Integer end) {
        super(adapt(id), new RangeParameter(start, end));
    }
}

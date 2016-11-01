package org.jjfflyboy.mpc4j;

/**
 * prio command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * @author jfraney
 */
public class Prio extends Simple {

    public Prio(Integer priority, Integer startPos, Integer endPos) {
        super(adapt(priority), new RangeParameter(startPos, endPos));
    }
}

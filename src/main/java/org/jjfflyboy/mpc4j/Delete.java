package org.jjfflyboy.mpc4j;

/**
 * delete command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * @author jfraney
 */
public class Delete extends Simple {

    public Delete(Integer pos) {
        super(adapt(pos));
    }
    public Delete(Integer start, Integer end) {
        super(new RangeParameter(start, end));
    }
}

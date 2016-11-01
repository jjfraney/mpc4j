package org.jjfflyboy.mpc4j;

/**
 * swapid command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * @author jfraney
 */
public class SwapId extends Simple {
    public SwapId(Integer id1, Integer id2) {
        super(adapt(id1), adapt(id2));
    }
}

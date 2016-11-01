package org.jjfflyboy.mpc4j;

/**
 * swap command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * @author jfraney
 */
public class Swap extends Simple {
    public Swap(Integer pos1, Integer pos2) {
        super(adapt(pos1), adapt(pos2));
    }
}

package org.jjfflyboy.mpc4j;

/**
 * moveid command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * @author jfraney
 */
public class MoveId extends Simple {
    public MoveId(Integer songId, Integer to) {
        super(adapt(songId), adapt(to));
    }
}

package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class MoveId extends Simple {
    public MoveId(Integer songId, Integer to) {
        super(adapt(songId), adapt(to));
    }
}

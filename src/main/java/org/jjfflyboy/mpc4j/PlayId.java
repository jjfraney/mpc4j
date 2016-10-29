package org.jjfflyboy.mpc4j;

/**
 * @Author jfraney
 */
public class PlayId extends Simple {
    public PlayId() {
        super();
    }
    public PlayId(Integer songId) {
        super(adapt(songId));
    }
}

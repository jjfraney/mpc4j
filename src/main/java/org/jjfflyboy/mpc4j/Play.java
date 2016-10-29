package org.jjfflyboy.mpc4j;

/**
 * @Author jfraney
 */
public class Play extends Simple {
    public Play() {
        super();
    }
    public Play(Integer songpos) {
        super(adapt(songpos));
    }
}

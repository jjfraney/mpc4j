package org.jjfflyboy.mpc4j;

/**
 * @Author jfraney
 */
public class Crossfade extends Simple {
    public Crossfade(Integer crossfade) {
        super(adapt(crossfade));
    }
    public Crossfade() {
        super(adapt(0));
    }
}

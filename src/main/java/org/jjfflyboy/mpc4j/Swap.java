package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class Swap extends Simple {
    public Swap(Integer pos1, Integer pos2) {
        super(adapt(pos1), adapt(pos2));
    }
}

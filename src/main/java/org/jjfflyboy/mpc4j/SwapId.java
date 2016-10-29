package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class SwapId extends Simple {
    public SwapId(Integer id1, Integer id2) {
        super(adapt(id1), adapt(id2));
    }
}

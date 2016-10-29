package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class SetVol extends Simple {
    public SetVol(Integer vol) {
        super(adapt(vol));
    }
}

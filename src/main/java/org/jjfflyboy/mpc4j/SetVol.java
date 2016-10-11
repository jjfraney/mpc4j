package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class SetVol extends Simple {
    private Integer vol;

    public SetVol(Integer vol) {
        this.vol = vol;
    }

    @Override
    public String text() {
        return "setvol " + vol.toString();
    }
}

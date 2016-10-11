package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class MixRampDelay extends Simple {
    final private Integer mixRampDelay;

    /**
     * A value or 'nan'.  Note: per protocol,'nan' disables MixRamp overlapping.
     * @param mixRampDelay value or null (for 'nan').
     */
    public MixRampDelay(Integer mixRampDelay) {
        this.mixRampDelay = mixRampDelay;
    }

    /**
     * send value of 'nan'.
     */
    public MixRampDelay() {
        this.mixRampDelay = null;
    }

    @Override
    public String text() {
        return "mixrampdelay " + ((mixRampDelay == null) ? "nan" : mixRampDelay.toString());
    }
}

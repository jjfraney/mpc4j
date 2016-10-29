package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class MixRampDelay extends Simple {
    private static Parameter NAN = adapt("nan");
    /**
     * A value or 'nan'.  Note: per protocol,'nan' disables MixRamp overlapping.
     * @param mixRampDelay value or null (for 'nan').
     */
    public MixRampDelay(Integer mixRampDelay) {
        super(adapt(mixRampDelay));
    }

    /**
     * send value of 'nan'.
     */
    public MixRampDelay() {
        super(NAN);
    }
}

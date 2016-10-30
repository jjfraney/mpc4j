package org.jjfflyboy.mpc4j;

/**
 * mixrampdelay command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_option_commands.html'>MPD Playback option commands.</a>
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

package musicpd.protocol;

import com.github.jjfraney.mpc.Parameter;

/**
 * mixrampdelay command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_option_commands.html'>
 *     MPD Playback option commands.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class MixRampDelay extends Simple {
    private static final Parameter NAN = adapt("nan");
    /**
     * A value or 'nan'.  Note: per protocol,'nan' disables MixRamp overlapping.
     * @param seconds of delay, or null for nan
     */
    public MixRampDelay(final Integer seconds) {
        super(adapt(seconds));
    }

    /**
     * sets mixrampdelay to nan, i.e., fallback to crossfading.
     */
    public MixRampDelay() {
        super(NAN);
    }
}

package org.jjfflyboy.mpc4j;

import java.math.BigDecimal;

/**
 * mixrampdn command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_option_commands.html'>MPD Playback option commands.</a>
 * @author jfraney
 */
public class MixRampDB extends Simple {
    /**
     * @param deciBels threshold
     */
    public MixRampDB(BigDecimal deciBels) {
        super(adapt(deciBels));
    }
}

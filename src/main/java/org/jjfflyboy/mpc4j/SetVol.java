package org.jjfflyboy.mpc4j;

/**
 * setvol command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_option_commands.html'>MPD Playback option commands.</a>
 * @author jfraney
 */
public class SetVol extends Simple {
    public SetVol(Integer vol) {
        super(adapt(vol));
    }
}

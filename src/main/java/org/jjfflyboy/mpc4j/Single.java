package org.jjfflyboy.mpc4j;

/**
 * single command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_option_commands.html'>MPD Playback option commands.</a>
 * @author jfraney
 */
public class Single extends Simple {
    public Single(Toggle toggle) {
        super(toggle);
    }
}

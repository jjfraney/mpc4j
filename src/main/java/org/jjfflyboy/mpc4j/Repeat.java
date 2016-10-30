package org.jjfflyboy.mpc4j;

/**
 * repeat command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_option_commands.html'>MPD Playback option commands.</a>
 * @author jfraney
 */
public class Repeat extends Simple {
    public Repeat(Toggle toggle) {
        super(toggle);
    }
}

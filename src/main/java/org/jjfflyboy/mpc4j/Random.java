package org.jjfflyboy.mpc4j;

/**
 * random command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_option_commands.html'>MPD Playback option commands.</a>
 * @author jfraney
 */
public class Random extends Simple {
    public Random(Toggle toggle) {
        super(toggle);
    }
}

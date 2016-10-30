package org.jjfflyboy.mpc4j;

/**
 * crossfade command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_option_commands.html'>MPD Playback option commands.</a>
 * @Author jfraney
 */
public class Crossfade extends Simple {
    public Crossfade(Integer crossfade) {
        super(adapt(crossfade));
    }
    public Crossfade() {
        super(adapt(0));
    }
}

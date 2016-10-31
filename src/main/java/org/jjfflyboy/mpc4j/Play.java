package org.jjfflyboy.mpc4j;

/**
 * play command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_commands.html'>MPD Document: Control playback.</a>
 * @Author jfraney
 */
public class Play extends Simple {
    public Play() {
        super();
    }
    public Play(Integer songpos) {
        super(adapt(songpos));
    }
}

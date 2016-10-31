package org.jjfflyboy.mpc4j;

/**
 * playid command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_commands.html'>MPD Document: Control playback.</a>
 * @Author jfraney
 */
public class PlayId extends Simple {
    public PlayId() {
        super();
    }
    public PlayId(Integer songId) {
        super(adapt(songId));
    }
}

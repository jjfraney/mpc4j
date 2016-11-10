package org.jjflyboy.mpc4j;

/**
 * playid command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_commands.html'>MPD Document: Control playback.</a>
 * @Author jfraney
 */
public class PlayId extends Simple {
    /**
     * plays from first song in queue
     */
    public PlayId() {
        super();
    }


    /**
     * plays from selected song in the queue
     * @param songId of selected song
     */
    public PlayId(Integer songId) {
        super(adapt(songId));
    }
}

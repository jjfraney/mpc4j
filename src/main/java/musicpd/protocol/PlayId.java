package musicpd.protocol;

/**
 * playid command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_commands.html'>
 *     MPD Document: Control playback.</a>
 * @author jfraney
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
    public PlayId(final Integer songId) {
        super(adapt(songId));
    }
}

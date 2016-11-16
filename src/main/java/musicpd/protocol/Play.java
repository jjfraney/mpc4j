package musicpd.protocol;

/**
 * play command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_commands.html'>
 *     MPD Document: Control playback.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class Play extends Simple {
    /**
     * play from first song on the queue
     */
    public Play() {
        super();
    }

    /**
     * play from this song position
     * @param songpos of first song to play
     */
    public Play(final Integer songpos) {
        super(adapt(songpos));
    }
}

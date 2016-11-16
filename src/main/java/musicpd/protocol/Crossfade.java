package musicpd.protocol;

/**
 * crossfade command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_option_commands.html'>
 *     MPD Playback option commands.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class Crossfade extends Simple {
    /**
     * @param crossfade in seconds
     */
    public Crossfade(final Integer crossfade) {
        super(adapt(crossfade));
    }

    /**
     * sets crossfade to 0 seconds.
     */
    public Crossfade() {
        super(adapt(0));
    }
}

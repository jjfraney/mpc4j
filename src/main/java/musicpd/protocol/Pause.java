package musicpd.protocol;

import com.github.jjfraney.mpc.Toggle;

/**
 * pause command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_commands.html'>
 *     MPD Document: Control playback.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class Pause extends Simple {
    /**
     * @param toggle on or off
     */
    public Pause(final Toggle toggle) {
        super(toggle);
    }
}

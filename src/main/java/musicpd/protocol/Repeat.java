package musicpd.protocol;

import com.github.jjfraney.mpc.Toggle;

/**
 * repeat command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_option_commands.html'>
 *     MPD Playback option commands.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class Repeat extends Simple {
    /**
     * @param toggle on or off
     */
    public Repeat(final Toggle toggle) {
        super(toggle);
    }
}

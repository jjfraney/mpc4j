package musicpd.protocol;

import com.github.jjfraney.mpc.Toggle;

/**
 * consume command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_option_commands.html'>
 *     MPD Playback option commands.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class Consume extends Simple {

    /**
     * @param toggle on or off
     */
    public Consume(final Toggle toggle) {
        super(toggle);
    }
}

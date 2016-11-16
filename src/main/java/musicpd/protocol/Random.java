package musicpd.protocol;

import org.jjflyboy.mpc.Toggle;

/**
 * random command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_option_commands.html'>
 *     MPD Playback option commands.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class Random extends Simple {
    /**
     * @param toggle on or off
     */
    public Random(final Toggle toggle) {
        super(toggle);
    }
}

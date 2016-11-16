package musicpd.protocol;

import org.jjflyboy.mpc.Toggle;

/**
 * repeat command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_option_commands.html'>
 *     MPD Playback option commands.</a>
 * @author jfraney
 */
public class Repeat extends Simple {
    /**
     * @param toggle on or off
     */
    public Repeat(final Toggle toggle) {
        super(toggle);
    }
}

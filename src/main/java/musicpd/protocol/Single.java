package musicpd.protocol;

import org.jjflyboy.mpc.Toggle;

/**
 * single command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_option_commands.html'>
 *     MPD Playback option commands.</a>
 * @author jfraney
 */
public class Single extends Simple {
    public Single(final Toggle toggle) {
        super(toggle);
    }
}

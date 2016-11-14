package musicpd.protocol;

import org.jjflyboy.mpc.Toggle;

/**
 * random command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_option_commands.html'>MPD Playback option commands.</a>
 * @author jfraney
 */
public class Random extends Simple {
    /**
     * @param toggle on or off
     */
    public Random(Toggle toggle) {
        super(toggle);
    }
}

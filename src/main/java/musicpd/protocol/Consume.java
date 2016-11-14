package musicpd.protocol;

import org.jjflyboy.mpc.Toggle;

/**
 * consume command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_option_commands.html'>MPD Playback option commands.</a>
 * @author jfraney
 */
public class Consume extends Simple {

    /**
     * @param toggle on or off
     */
    public Consume(Toggle toggle) {
        super(toggle);
    }
}

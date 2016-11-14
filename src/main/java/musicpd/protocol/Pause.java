package musicpd.protocol;

import org.jjflyboy.mpc.Toggle;

/**
 * pause command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_commands.html'>MPD Document: Control playback.</a>
 * @author jfraney
 */
public class Pause extends Simple {
    /**
     * @param toggle on or off
     */
    public Pause(Toggle toggle) {
        super(toggle);
    }
}

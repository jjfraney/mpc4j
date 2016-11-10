package org.jjflyboy.mpc4j;

/**
 * repeat command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_option_commands.html'>MPD Playback option commands.</a>
 * @author jfraney
 */
public class Repeat extends Simple {
    /**
     * @param toggle on or off
     */
    public Repeat(Toggle toggle) {
        super(toggle);
    }
}

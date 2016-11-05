package org.jjfflyboy.mpc4j;

/**
 * toggleoutput command from
 * <a href='https://www.musicpd.org/doc/protocol/output_commands.html'>MPD Document: Audio output devices.</a>
 * @Author jfraney
 */
public class ToggleOutput extends Simple {
    /**
     * @param id of output device
     */
    public ToggleOutput(Integer id) {
        super(adapt(id));
    }
}

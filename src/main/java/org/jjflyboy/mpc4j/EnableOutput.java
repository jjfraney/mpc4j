package org.jjflyboy.mpc4j;

/**
 * enableoutput command from
 * <a href='https://www.musicpd.org/doc/protocol/output_commands.html'>MPD Document: Audio output devices.</a>
 * @Author jfraney
 */
public class EnableOutput extends Simple {
    /**
     * @param id of output device
     */
    public EnableOutput(Integer id) {
        super(adapt(id));
    }
}

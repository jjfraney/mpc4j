package org.jjfflyboy.mpc4j;

import java.math.BigDecimal;

/**
 * seekcur command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_commands.html'>MPD Document: Control playback.</a>
 * @Author jfraney
 */
public class SeekCur extends Simple {

    private SeekCur(Number time) {
        super(adapt(time));
    }
    public SeekCur( Integer time) {
        this((Number)time);
    }
    public SeekCur(BigDecimal time) {
        this((Number)time);
    }
    public SeekCur(Float time) {
        this((Number)time);
    }
}

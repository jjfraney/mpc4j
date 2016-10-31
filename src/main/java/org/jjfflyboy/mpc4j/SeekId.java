package org.jjfflyboy.mpc4j;

import java.math.BigDecimal;

/**
 * seekid command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_commands.html'>MPD Document: Control playback.</a>
 * @Author jfraney
 */
public class SeekId extends Simple {
    private SeekId(Integer songid, Number time) {
        super(adapt(songid), adapt(time));
    }
    public SeekId(Integer songid, Integer time) {
        this(songid, (Number)time);
    }
    public SeekId(Integer songid, BigDecimal time) {
        this(songid, (Number)time);
    }
    public SeekId(Integer songid, Float time) {
        this(songid, (Number)time);
    }
}

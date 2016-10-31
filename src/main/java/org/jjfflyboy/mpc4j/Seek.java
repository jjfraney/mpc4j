package org.jjfflyboy.mpc4j;

import java.math.BigDecimal;

/**
 * seek command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_commands.html'>MPD Document: Control playback.</a>
 * @Author jfraney
 */
public class Seek extends Simple {
    private Seek(Integer songpos, Number time) {
        super(adapt(songpos), adapt(time));
    }
    public Seek(Integer songpos, Integer time) {
        this(songpos, (Number)time);
    }
    public Seek(Integer songpos, BigDecimal time) {
        this(songpos, (Number)time);
    }
    public Seek(Integer songpos, Float time) {
        this(songpos, (Number)time);
    }
}

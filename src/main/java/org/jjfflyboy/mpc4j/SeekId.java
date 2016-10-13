package org.jjfflyboy.mpc4j;

import java.math.BigDecimal;

/**
 * @Author jfraney
 */
public class SeekId extends Simple {
    private final Integer songid;
    private final Number time;

    private SeekId(Integer songid, Number time) {
        this.songid = songid;
        this.time = time;
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

    @Override
    public String text() {
        return new StringBuilder()
                .append("seekid ")
                .append(songid)
                .append(' ')
                .append(time)
                .toString();
    }
}

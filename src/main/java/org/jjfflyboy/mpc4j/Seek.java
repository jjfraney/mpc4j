package org.jjfflyboy.mpc4j;

import java.math.BigDecimal;

/**
 * @Author jfraney
 */
public class Seek extends Simple {
    private final Integer songpos;
    private final Number time;

    private Seek(Integer songpos, Number time) {
        this.songpos = songpos;
        this.time = time;
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

    @Override
    public String text() {
        return new StringBuilder()
                .append("seek ")
                .append(songpos)
                .append(' ')
                .append(time)
                .toString();
    }
}

package org.jjfflyboy.mpc4j;

import java.math.BigDecimal;

/**
 * @Author jfraney
 */
public class SeekCur extends Simple {
    private final Number time;

    private SeekCur(Number time) {
        this.time = time;
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

    @Override
    public String text() {
        return new StringBuilder()
                .append("seekcur ")
                .append(time)
                .toString();
    }
}

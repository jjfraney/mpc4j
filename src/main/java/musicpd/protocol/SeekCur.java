package musicpd.protocol;

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
    /**
     * @param time offset into current song
     */
    public SeekCur( Integer time) {
        this((Number)time);
    }
    /**
     * @param time offset into current song
     */
    public SeekCur(BigDecimal time) {
        this((Number)time);
    }
    /**
     * @param time offset into current  song
     */
    public SeekCur(Float time) {
        this((Number)time);
    }
}

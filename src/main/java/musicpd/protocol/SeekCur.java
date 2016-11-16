package musicpd.protocol;

import java.math.BigDecimal;

/**
 * seekcur command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_commands.html'>
 *     MPD Document: Control playback.</a>
 * @author jfraney
 */
public class SeekCur extends Simple {

    private SeekCur(final Number time) {
        super(adapt(time));
    }
    /**
     * @param time offset into current song
     */
    public SeekCur(final Integer time) {
        this((Number)time);
    }
    /**
     * @param time offset into current song
     */
    public SeekCur(final BigDecimal time) {
        this((Number)time);
    }
    /**
     * @param time offset into current  song
     */
    public SeekCur(final Float time) {
        this((Number)time);
    }
}

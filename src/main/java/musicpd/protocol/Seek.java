package musicpd.protocol;

import java.math.BigDecimal;

/**
 * seek command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_commands.html'>
 *     MPD Document: Control playback.</a>
 * @author jfraney
 */
public class Seek extends Simple {
    private Seek(final Integer songpos, final Number time) {
        super(adapt(songpos), adapt(time));
    }

    /**
     * @param songpos of selected song
     * @param time offset into selected song
     */
    public Seek(final Integer songpos, final Integer time) {
        this(songpos, (Number)time);
    }
    /**
     * @param songpos of selected song
     * @param time offset into selected song
     */
    public Seek(final Integer songpos, final BigDecimal time) {
        this(songpos, (Number)time);
    }
    /**
     * @param songpos of selected song
     * @param time offset into selected song
     */
    public Seek(final Integer songpos, final Float time) {
        this(songpos, (Number)time);
    }
}

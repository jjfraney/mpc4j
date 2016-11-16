package musicpd.protocol;

import java.math.BigDecimal;

/**
 * seekid command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_commands.html'>
 *     MPD Document: Control playback.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class SeekId extends Simple {
    private SeekId(final Integer songid, final Number time) {
        super(adapt(songid), adapt(time));
    }

    /**
     * @param songid of selected song
     * @param time offset into selected song
     */
    public SeekId(final Integer songid, final Integer time) {
        this(songid, (Number)time);
    }
    /**
     * @param songid of selected song
     * @param time offset into selected song
     */
    public SeekId(final Integer songid, final BigDecimal time) {
        this(songid, (Number)time);
    }
    /**
     * @param songid of selected song
     * @param time offset into selected song
     */
    public SeekId(final Integer songid, final Float time) {
        this(songid, (Number)time);
    }
}

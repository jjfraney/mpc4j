package musicpd.protocol;

import com.github.jjfraney.mpc.RangeParameter;

/**
 * prio command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>
 *     MPD Document: The current playlist.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class Prio extends Simple {

    /**
     * @param priority to apply to selected songs
     * @param startPos of first selected song
     * @param endPos of last selected song
     */
    public Prio(final Integer priority, final Integer startPos, final Integer endPos) {
        super(adapt(priority), new RangeParameter(startPos, endPos));
    }
}

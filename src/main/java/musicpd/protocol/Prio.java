package musicpd.protocol;

import org.jjflyboy.mpc.RangeParameter;

/**
 * prio command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * @author jfraney
 */
public class Prio extends Simple {

    /**
     * @param priority to apply to selected songs
     * @param startPos of first selected song
     * @param endPos of last selected song
     */
    public Prio(Integer priority, Integer startPos, Integer endPos) {
        super(adapt(priority), new RangeParameter(startPos, endPos));
    }
}

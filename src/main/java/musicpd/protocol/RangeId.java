package musicpd.protocol;

import org.jjflyboy.mpc.RangeParameter;

/**
 * rangeid command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * @author jfraney
 */
public class RangeId extends Simple {
    /**
     * @param id of song to play
     * @param start of range or null
     * @param end of range or null
     */
    public RangeId(Integer id, Integer start, Integer end) {
        super(adapt(id), new RangeParameter(start, end));
    }

    /**
     * command form: 'rangeid <id> :'
     * @param id of song to play
     */
    public RangeId(Integer id) { this(id, null, null);}
}

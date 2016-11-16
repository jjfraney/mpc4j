package musicpd.protocol;

import com.github.jjfraney.mpc.RangeParameter;

/**
 * rangeid command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>
 *     MPD Document: The current playlist.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class RangeId extends Simple {
    /**
     * @param id of song to play
     * @param start of range or null
     * @param end of range or null
     */
    public RangeId(final Integer id, final Integer start, final Integer end) {
        super(adapt(id), new RangeParameter(start, end));
    }

    /**
     * command form: 'rangeid <id> :'
     * @param id of song to play
     */
    public RangeId(final Integer id) { super(adapt(id));}
}

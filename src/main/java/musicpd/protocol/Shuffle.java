package musicpd.protocol;

import com.github.jjfraney.mpc.RangeParameter;

/**
 * shuffle command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>
 *     MPD Document: The current playlist.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class Shuffle extends Simple {

    /**
     * shuffle all songs on playlist
     */
    public Shuffle() {
        super();
    }

    /**
     * shuffle songs between start:end
     * @param start first song of selected range
     * @param end last song of selected range
     */
    public Shuffle(final Integer start, final Integer end) {
        super(new RangeParameter(start, end));
        if(start == null) {
            throw new IllegalArgumentException("start must not be null");
        }
    }
}

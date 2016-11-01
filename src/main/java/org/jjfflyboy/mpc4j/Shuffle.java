package org.jjfflyboy.mpc4j;

/**
 * shuffle command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * @author jfraney
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
    public Shuffle(Integer start, Integer end) {
        super(new RangeParameter(start, end));
        if(start == null) {
            throw new IllegalArgumentException("start must not be null");
        }
        if(end == null) {
            throw new IllegalArgumentException("end must not be null");
        }
    }
}

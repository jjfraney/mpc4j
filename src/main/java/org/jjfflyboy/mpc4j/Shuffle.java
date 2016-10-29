package org.jjfflyboy.mpc4j;

/**
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
     * @param start
     * @param end
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

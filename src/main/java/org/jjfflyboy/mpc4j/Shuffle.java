package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class Shuffle extends Simple {
    private final Integer start;
    private final Integer end;

    /**
     * shuffle all songs on playlist
     */
    public Shuffle() {
        start = null;
        end = null;
    }

    /**
     * shuffle songs between start:end
     * @param start
     * @param end
     */
    public Shuffle(Integer start, Integer end) {
        if(start == null) {
            throw new IllegalArgumentException("start must not be null");
        }
        if(end == null) {
            throw new IllegalArgumentException("end must not be null");
        }
        this.start = start;
        this.end = end;
    }

    @Override
    public String text() {
        StringBuilder sb = new StringBuilder();

        sb.append("shuffle");
        if(start != null) {
            sb.append(" ")
                    .append(start)
                    .append(":")
                    .append(end);
        }
        return sb.toString();
    }
}

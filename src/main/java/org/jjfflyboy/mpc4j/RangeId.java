package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class RangeId extends Simple {
    private final Integer id;
    private final Integer start;
    private final Integer end;

    public RangeId(Integer id, Integer start, Integer end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }
    @Override
    public String text() {
        return new StringBuilder()
                .append("rangeid ")
                .append(id)
                .append(" ")
                .append(start)
                .append(":")
                .append(end)
                .toString();
    }
}

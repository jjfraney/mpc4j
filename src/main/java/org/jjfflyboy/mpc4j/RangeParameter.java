package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class RangeParameter implements Parameter {
    private final Integer start;
    private final Integer end;
    public RangeParameter(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }
    public String toParameter() {
        return new StringBuilder()
                .append(start)
                .append(":")
                .append(end)
                .toString();
    }
}

package org.jjflyboy.mpc4j;

/**
 * @author jfraney
 */
public class RangeParameter implements Parameter {
    private final Integer start;
    private final Integer end;

    /**
     * parameter of form 'start:end'.  ':end', 'start:' or ':' may be valid parameter.
     * @param start of range or null
     * @param end or range or null
     */
    public RangeParameter(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }
    public String toParameter() {
        return new StringBuilder()
                .append(start == null ? "" : start.toString())
                .append(":")
                .append(end == null ? "" : end.toString())
                .toString();
    }
}

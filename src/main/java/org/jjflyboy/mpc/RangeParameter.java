package org.jjflyboy.mpc;

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
    public RangeParameter(final Integer start, final Integer end) {
        this.start = start;
        this.end = end;
    }
    public String toParameter() {
        return (start == null ? "" : start.toString()) +
                ":" +
                (end == null ? "" : end.toString());
    }
}

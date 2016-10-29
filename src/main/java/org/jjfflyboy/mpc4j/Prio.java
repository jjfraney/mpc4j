package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class Prio extends Simple {
    private final Integer priority;
    private final Integer startPos;
    private final Integer endPos;

    public Prio(Integer priority, Integer startPos, Integer endPos) {
        this.priority = priority;
        this.startPos = startPos;
        this.endPos = endPos;
    }
    @Override
    public String text() {
        return new StringBuilder()
                .append("prio ")
                .append(priority)
                .append(" ")
                .append(startPos)
                .append(":")
                .append(endPos)
                .toString();
    }
}

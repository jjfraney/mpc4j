package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class Move extends Simple {
    private final Integer to;
    private final Integer from;
    private final Integer start;
    private final Integer end;

    public Move(Integer from, Integer to) {
        this.from = from;
        this.to = to;
        this.start = null;
        this.end = null;
    }
    public Move(Integer start, Integer end, Integer to) {
        this.from = null;
        this.to = to;
        this.start = start;
        this.end = end;
    }

    @Override
    public String text() {
        StringBuilder sb = new StringBuilder()
                .append("move ")
                ;
        if(from != null) {
            sb.append(from);
        } else {
            sb.append(start).append(":").append(end);
        }
        sb.append(" ").append(to);
        return sb.toString();
    }
}

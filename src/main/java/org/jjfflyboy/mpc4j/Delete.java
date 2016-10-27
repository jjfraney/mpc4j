package org.jjfflyboy.mpc4j;

import java.util.Optional;

/**
 * @author jfraney
 */
public class Delete extends Simple {
    private final Integer pos;
    private final Integer start;
    private final Integer end;

    public Delete(Integer pos) {
        this.pos = pos;
        this.start = null;
        this.end = null;
    }
    public Delete(Integer start, Integer end) {
        this.start = start;
        this.end = end;
        this.pos = null;
    }

    @Override
    public String text() {
        StringBuilder sb = new StringBuilder()
                .append("delete ")
                ;
        if(pos != null) {
            sb.append(pos);
        } else {
            sb.append(start).append(":").append(end);
        }
        return sb.toString();
    }
}

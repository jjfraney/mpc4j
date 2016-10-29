package org.jjfflyboy.mpc4j;

import java.util.Arrays;

/**
 * @author jfraney
 */
public class PrioId extends Simple {
    private final Integer priority;
    private final Integer id;
    private final Integer[] ids;

    public PrioId(Integer priority, Integer id, Integer ... ids) {
        this.priority = priority;
        this.id = id;
        this.ids = ids;
    }
    @Override
    public String text() {
        StringBuilder sb = new StringBuilder()
                .append("prioid ")
                .append(priority)
                .append(" ")
                .append(id);
        Arrays.stream(ids).map(id -> " " + id).forEach(sb::append);
        return sb.toString();
    }
}

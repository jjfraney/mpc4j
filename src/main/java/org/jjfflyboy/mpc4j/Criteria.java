package org.jjfflyboy.mpc4j;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class provides parameters for find and derivatives.
 * @author jfraney
 */
public class Criteria {

    interface Type {
        /**
         * convert the type to string as it would appear in mpd command.
         * @return
         */
        String toParameter();
    }

    private final Map<Criteria.Type, String> criteria;

    public Criteria(Map<? extends Type, String> criteria) {
        this.criteria = Collections.unmodifiableMap(criteria);
    }

    /**
     * flattens the criteria to: "type what [....]"
     */
    public String toParameters() {
        String result = criteria
                .entrySet()
                .stream()
                .map(this::flatten)
                .collect(Collectors.joining(" "));
        return result;

    }
    private String flatten(Map.Entry<? extends Criteria.Type, String> e) {
        return new StringBuilder()
                .append(e.getKey().toParameter())
                .append(" ")
                .append('"')
                .append(e.getValue())
                .append('"')
                .toString();
    }
}

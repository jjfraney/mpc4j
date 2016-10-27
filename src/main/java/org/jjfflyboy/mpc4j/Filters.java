package org.jjfflyboy.mpc4j;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * This class models filter arguments in use by some database commands.
 * A filter is a pair: a field name and a value.
 * MPD will return data to match the value of the specified field name.
 * @author jfraney
 */
public class Filters {

    /**
     * The field name of a filter-like parameter.
     */
    interface Field {
        /**
         * convert the name to string as it would appear in mpd command.
         * @return
         */
        String toParameter();
    }

    /**
     * a 'field-value' pair to specify a filter-like parameter.
     */
    public abstract static class Filter {
        private final Field field;
        private final String value;
        protected Filter(Field field, String value) {
            this.field = field;
            this.value = value;
        }
        public Field getField() {
            return field;
        }
        public String getValue() {
            return value;
        }
    }

    private final Filter[] filters;

    public Filters(Filter... filters) {
        this.filters = filters;
    }

    /**
     * convert the filter pairs to a string as would appear on the command.
     */
    public String toParameters() {
        String result = Arrays.stream(filters)
                .map(this::flatten)
                .collect(Collectors.joining(" "));
        return result;

    }
    private String flatten(Filter filter) {
        return new StringBuilder()
                .append(filter.getField().toParameter())
                .append(" ")
                .append('"')
                .append(filter.getValue())
                .append('"')
                .toString();
    }
}

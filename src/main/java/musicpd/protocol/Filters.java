package musicpd.protocol;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * This class models filter arguments in use by some database commands.
 * A filter is a pair: a field name and a value.
 * MPD will return data to match the value of the specified field name.
 * @author jfraney
 */
public class Filters implements Parameter {

    /**
     * The field name of a filter-like parameter.
     */
    interface Field extends Parameter {
    }

    /**
     * a 'field-value' pair to specify a filter-like parameter.
     */
    public abstract static class Filter implements Parameter {
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

        @Override
        public String toParameter() {
            return new StringBuilder()
                    .append(getField().toParameter())
                    .append(" ")
                    .append('"')
                    .append(getValue())
                    .append('"')
                    .toString();
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
                .map(Filter::toString)
                .collect(Collectors.joining(" "));
        return result;

    }

    @Override
    public String toParameter() {
        return Arrays.stream(filters).map(Filter::toParameter).collect(Collectors.joining(" "));
    }
}

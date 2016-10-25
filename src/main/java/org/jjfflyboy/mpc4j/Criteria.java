package org.jjfflyboy.mpc4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class models a filter in use by some database commands.
 * A filter is a pair: a field name and a value.
 * MPD will return data to match the value of the specified field name.
 * <p>
 *     The MPD document for the 'find' command identifies the
 *     filter's field name as 'TYPE' and the value name as 'WHAT'.
 *     This class adopts that terminology.
 * </p>
 * @author jfraney
 */
public class Criteria {

    /**
     * The field name of a filter-like parameter.
     */
    interface Type {
        /**
         * convert the name to string as it would appear in mpd command.
         * @return
         */
        String toParameter();
    }

    /**
     * a 'field-value' pair to specify a filter-like parameter.
     */
    public abstract static class Term {
        private final Type type;
        private final String what;
        protected Term(Type type, String what) {
            this.type = type;
            this.what = what;
        }
        public Type getType() {
            return type;
        }
        public String getWhat() {
            return what;
        }
    }

    private final List<? extends Term> terms;

    public Criteria(List<? extends Term> terms) {
        this.terms = Collections.unmodifiableList(terms);
    }
    public Criteria(Term... terms) {
        this.terms = Collections.unmodifiableList(Arrays.asList(terms));
    }

    /**
     * convert the filter pairs to a string as would appear on the command.
     */
    public String toParameters() {
        String result = terms
                .stream()
                .map(this::flatten)
                .collect(Collectors.joining(" "));
        return result;

    }
    private String flatten(Term term) {
        return new StringBuilder()
                .append(term.getType().toParameter())
                .append(" ")
                .append('"')
                .append(term.getWhat())
                .append('"')
                .toString();
    }
}

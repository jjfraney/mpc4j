package org.jjfflyboy.mpc4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

    /**
     * specifies a 'term': type-what, tag-needle or filtertype-filterwhat pair
     * of 'find'/'search', 'count', or 'list' commands (respectively).
     * The type-what form is common among database queries in the mpd protocol,
     * though they use different names.  The names may be different but the
     * purpose remains.  Each specifies some real or virtual tag and a value
     * to match exactly or as a pattern.
     * The prevalent terms, type-what, are used here.
     */
    public static class Term {
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
     * flattens the criteria to: "type what [....]"
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

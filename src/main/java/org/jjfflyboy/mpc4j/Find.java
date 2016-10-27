package org.jjfflyboy.mpc4j;

import java.util.List;

/**
 * Support the find command.
 * <p>
 *     note: the only mpd protocol document (https://www.musicpd.org/doc/protocol/database.html)
 *     identifies 'window' option.
 *     A live mpd server fails to parse a command with 'window' option.
 *     The source code for mpd version 0.19.x does not have 'window' option.
 *     So, there is not support for 'window' option here.
 *
 * </p>
 * @author jfraney
 */
public class Find extends AbstractSongSearch {

    /**
     * the find (and others) field-name parameter.
     * Currently, either a TAG or a special type.
     */
    interface Type extends Filters.Field {
    }

    public static class Filter extends Filters.Filter {

        protected Filter(Find.Type type, String what) {
            super(type, what);
        }
    }

    // find's TYPE may be a TAG or a special type.
    // observe that enum Tag implements Find.Type.

    /**
     * find's TYPE may be one of these.
     */
    public enum Special implements Type {
        ANY, FILE, BASE, MODIFIED_SINCE;

        @Override
        public String toParameter() {
            switch(this) {
                case MODIFIED_SINCE:
                    return "modified-since";
                default:
                    return name().toLowerCase();
            }
        }
    }

    private final Filters filters;

    /**
     * a command of form: 'find {TYPE} "{WHAT}"'
     * @param type name of field to match
     * @param what value to match
     */
    public Find(Type type, String what) {
        Filter filter = new Filter(type, what);
        filters = new Filters(filter);
    }

    /**
     * a command of form: 'find {TYPE} "{WHAT}" [...]'.
     * @param filters array of TYPE-WHAT filter pairs.
     */
    public Find(Filter... filters) {
        this.filters = new Filters(filters);
    }
    /**
     * a command of form: 'find {TYPE} "{WHAT}" [...]'.
     * @param filters array of TYPE-WHAT filter pairs.
     */
    public Find(List<? extends Filter> filters) {
        this.filters = new Filters(filters);
    }

    @Override
    public String text() {
        return "find " + getFilters().toParameters();
    }

    protected Filters getFilters() {
        return filters;
    }
}

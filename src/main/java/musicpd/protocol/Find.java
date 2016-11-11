package musicpd.protocol;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * find command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>MPD Document: The music database.</a>
 * <p>
 *     On this command, mpd returns database metadata for each song.
 * </p>
 * <p>
 *     note: the only mpd protocol document
 *     identifies 'window' option.
 *     However, a live mpd server fails to parse a command with 'window' option.
 *     The source code for mpd version 0.19.x does not have 'window' option.
 *     So, there is not support for 'window' option here.
 *
 * </p>
 * @author jfraney
 */
public class Find extends DatabaseQuery {

    /**
     * the find (and others) field-name parameter.
     * Currently, either a TAG or a special type.
     */
    interface Type extends Filters.Field {
    }

    /**
     * 'filter' segment of a find command
     */
    public static class Filter extends Filters.Filter {
        /**
         * allows filter only by this Find.Type values.  As per
         * mpd document, match songs with name of 'type' and value below.
         * @param type  An enum of type Find.Type.
         * @param what  The value to match against the metadata of the Find.Type.
         * @see Find.Special
         * @see Tag        */
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

    /**
     * a command of form: 'find {TYPE} "{WHAT}"'
     * @param type name of field to match
     * @param what value to match
     */
    public Find(Type type, String what) {
        super(new Filter(type, what));
    }

    public static abstract class AbstractBuilder<B extends AbstractBuilder, T extends DatabaseQuery> {
        private final java.util.List<Filter> filters = new ArrayList<>();
        protected AbstractBuilder() {};

        public B with(Type type, String what) {
            filters.add(new Filter(type, what));
            return (B)this;
        }
        protected java.util.List<Filter> getFilters() {return filters;}

        protected abstract T build();
    }

    private Find(java.util.List<Filter> filters) {
        super(new ArrayList<>(filters));
    }

    public static class Builder extends AbstractBuilder<Builder, Find> {
        @Override
        protected Find build() {
            return new Find(getFilters());
        }
    }

    public static Find build(Consumer<Builder> c) {
        Builder b = new Builder();
        c.accept(b);
        return b.build();
    }
}

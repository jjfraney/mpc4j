package musicpd.protocol;

import org.jjflyboy.mpc.DatabaseQuery;
import org.jjflyboy.mpc.FilterParameter;
import org.jjflyboy.mpc.Parameter;

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
     * find's TYPE also may be one of these.
     */
    public enum Special implements Parameter {
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
     * @see musicpd.protocol.Tag
     */
    public Find(Tag type, String what) {
        super(new FilterParameter(type, what));
    }
    /**
     * a command of form: 'find {TYPE} "{WHAT}"'
     * @param type name of field to match
     * @param what value to match
     * @see musicpd.protocol.Find.Special
     */
    public Find(Special type, String what) {
        super(new FilterParameter(type, what));
    }

    public static abstract class AbstractBuilder<B extends AbstractBuilder, T extends DatabaseQuery> {
        private final java.util.List<FilterParameter> filters = new ArrayList<>();
        protected AbstractBuilder() {};

        /**
         * with a tag as {TYPE}
         * @param type name of field to match
         * @param what value to match
         * @see musicpd.protocol.Tag
         */
        public B with(Tag type, String what) {
            filters.add(new FilterParameter(type, what));
            return (B)this;
        }
        /**
         * with a Special as {TYPE}
         * @param type name of field to match
         * @param what value to match
         * @see musicpd.protocol.Tag
         */
        public B with(Special type, String what) {
            filters.add(new FilterParameter(type, what));
            return (B)this;
        }
        protected java.util.List<FilterParameter> getFilters() {return filters;}

        protected abstract T build();
    }

    private Find(java.util.List<FilterParameter> filters) {
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

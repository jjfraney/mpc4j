package musicpd.protocol;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * search command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>MPD Document: The music database.</a>
 * <p>
 *     On this command, mpd returns database metadata for each song.
 * </p>
 * @author jfraney
 */
public class Search extends DatabaseQuery {

    /**
     * a command of form: 'search {TYPE} "{WHAT}"
     * @param type name of field to match
     * @param what value to match
     */
    public Search(Find.Type type, String what) {
        super(new FilterParameter(type, what));
    }

    private Search(java.util.List<FilterParameter> filters) {
        super(new ArrayList<>(filters));
    }

    public static class Builder extends Find.AbstractBuilder<Search.Builder, Search> {
        @Override
        protected Search build() {
            return new Search(getFilters());
        }
    }

    public static Search build(Consumer<Builder> c) {
        Builder b = new Builder();
        c.accept(b);
        return b.build();
    }
}

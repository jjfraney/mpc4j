package musicpd.protocol;

import org.jjflyboy.mpc.DatabaseQuery;
import org.jjflyboy.mpc.FilterParameter;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * search command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>
 *     MPD Document: The music database.</a>
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
    public Search(final Tag type, final String what) {
        super(new FilterParameter(type, what));
    }
    /**
     * a command of form: 'search {TYPE} "{WHAT}"
     * @param type name of field to match
     * @param what value to match
     */
    public Search(final Find.Special type, final String what) {
        super(new FilterParameter(type, what));
    }

    private Search(final java.util.List<FilterParameter> filters) {
        super(new ArrayList<>(filters));
    }

    public static class Builder extends Find.AbstractBuilder<Search.Builder, Search> {
        @Override
        protected Search build() {
            return new Search(getFilters());
        }
    }

    public static Search build(final Consumer<Builder> c) {
        final Builder b = new Builder();
        c.accept(b);
        return b.build();
    }
}

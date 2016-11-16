package musicpd.protocol;

import org.jjflyboy.mpc.DatabaseQuery;
import org.jjflyboy.mpc.FilterParameter;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * searchadd command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>
 *     MPD Document: The music database.</a>
 * <p>
 *     On this command, mpd returns database metadata for each song.
 * </p>
 * @author jfraney
 */
public class SearchAdd extends DatabaseQuery {

    /**
     * a command of form: 'searchadd {TYPE} "{WHAT}"
     * @param type name of field to match
     * @param what value to match
     */
    public SearchAdd(final Tag type, final String what) {
        super(new FilterParameter(type, what));
    }
    /**
     * a command of form: 'searchadd {TYPE} "{WHAT}"
     * @param type name of field to match
     * @param what value to match
     */
    public SearchAdd(final Find.Special type, final String what) {
        super(new FilterParameter(type, what));
    }

    private SearchAdd(final java.util.List<FilterParameter> filters) {
        super(new ArrayList<>(filters));
    }

    public static class Builder extends Find.AbstractBuilder<SearchAdd.Builder, SearchAdd> {
        @Override
        protected SearchAdd build() {
            return new SearchAdd(getFilters());
        }
    }

    public static SearchAdd build(final Consumer<Builder> c) {
        final SearchAdd.Builder b = new SearchAdd.Builder();
        c.accept(b);
        return b.build();
    }
}

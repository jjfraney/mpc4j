package musicpd.protocol;

import org.jjflyboy.mpc.DatabaseQuery;
import org.jjflyboy.mpc.FilterParameter;
import org.jjflyboy.mpc.MpcRuntimeException;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * searchaddpl command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>
 *     MPD Document: The music database.</a>
 * <p>
 *     On this command, mpd returns database metadata for each song.
 * </p>
 * @author jfraney
 */
public class SearchAddPl extends DatabaseQuery {

    /**
     * a command of form: 'searchaddpl {Name} {TYPE} "{WHAT}"
     * @param type name of field to match
     * @param what value to match
     */
    public SearchAddPl(final String playlistName, final Tag type, final String what) {
        this(playlistName, new FilterParameter(type, what));
    }
    /**
     * a command of form: 'searchaddpl {Name} {TYPE} "{WHAT}"
     * @param type name of field to match
     * @param what value to match
     */
    public SearchAddPl(final String playlistName, final Find.Special type, final String what) {
        this(playlistName, new FilterParameter(type, what));
    }

    private SearchAddPl(final String playlistName, final FilterParameter fp) {
        super(adapt(playlistName), fp);
        if(playlistName == null) {
            throw new MpcRuntimeException("playlistName cannot be null");
        }
    }

    private SearchAddPl(final String playlistName, final java.util.List<FilterParameter> filters) {
        super(adapt(playlistName), adapt(new ArrayList<>(filters)));
    }

    public static class Builder extends Find.AbstractBuilder<SearchAddPl.Builder, SearchAddPl> {
        private String playlistName;

        public Builder playlist(final String name) {
            this.playlistName = name;
            return this;
        }
        @Override
        protected SearchAddPl build() {
            if(playlistName == null) {
                throw new MpcRuntimeException("playlistName cannot be null");
            }
            return new SearchAddPl(playlistName, getFilters());
        }
    }

    public static SearchAddPl build(final Consumer<Builder> c) {
        final SearchAddPl.Builder b = new SearchAddPl.Builder();
        c.accept(b);
        return b.build();
    }
}

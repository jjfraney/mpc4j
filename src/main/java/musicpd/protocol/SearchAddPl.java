package musicpd.protocol;

import org.jjflyboy.mpc.DatabaseQuery;
import org.jjflyboy.mpc.FilterParameter;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * searchaddpl command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>MPD Document: The music database.</a>
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
    public SearchAddPl(String playlistName, Tag type, String what) {
        this(playlistName, new FilterParameter(type, what));
    }
    /**
     * a command of form: 'searchaddpl {Name} {TYPE} "{WHAT}"
     * @param type name of field to match
     * @param what value to match
     */
    public SearchAddPl(String playlistName, Find.Special type, String what) {
        this(playlistName, new FilterParameter(type, what));
    }

    private SearchAddPl(String playlistName, FilterParameter fp) {
        super(adapt(playlistName), fp);
        if(playlistName == null) {
            throw new RuntimeException("playlistName cannot be null");
        }
    }

    private SearchAddPl(String playlistName, java.util.List<FilterParameter> filters) {
        super(adapt(playlistName), adapt(new ArrayList<>(filters)));
    }

    public static class Builder extends Find.AbstractBuilder<SearchAddPl.Builder, SearchAddPl> {
        private String playlistName;

        public Builder playlist(String name) {
            this.playlistName = name;
            return this;
        }
        @Override
        protected SearchAddPl build() {
            if(playlistName == null) {
                throw new RuntimeException("playlistName cannot be null");
            }
            return new SearchAddPl(playlistName, getFilters());
        }
    }

    public static SearchAddPl build(Consumer<Builder> c) {
        SearchAddPl.Builder b = new SearchAddPl.Builder();
        c.accept(b);
        return b.build();
    }
}

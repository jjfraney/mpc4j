package musicpd.protocol;

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
    public SearchAddPl(String playlistName, Find.Type type, String what) {
        super(adapt(playlistName), new Find.Filter(type, what));
        if(playlistName == null) {
            throw new RuntimeException("playlistName cannot be null");
        }
    }

    private SearchAddPl(String playlistName, java.util.List<Find.Filter> filters) {
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

package musicpd.protocol;

/**
 * playlistfind command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * <p>
 *     This command's response contains metadata of a queued song.
 * </p>
 * @author jfraney
 */
public class PlaylistFind extends QueueQuery {
    interface Tag extends Filters.Field {
    }
    public static class Filter extends Filters.Filter {
        protected Filter(PlaylistFind.Tag tag, String needle) {
            super(tag, needle);
        }
    }

    /**
     * @param tag of songs to return in result
     * @param needle (or value) of the tag of songs to return in result
     */
    public PlaylistFind(PlaylistFind.Tag tag, String needle) {
        super(new Filters(new Filter(tag, needle)));
    }

}

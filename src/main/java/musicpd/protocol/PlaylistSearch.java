package musicpd.protocol;

/**
 * playlistsearch command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * <p>
 *     This command's response contains metadata of a queued song.
 * </p>
 * @author jfraney
 */
public class PlaylistSearch extends QueueQuery {

    /**
     * @param tag of songs to return in result
     * @param needle (or value) of the tag of songs to return in result
     */
    public PlaylistSearch(Tag tag, String needle) {
        super(new FilterParameter(tag, needle));
    }
}

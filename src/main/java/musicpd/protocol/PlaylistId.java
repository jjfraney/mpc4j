package musicpd.protocol;

/**
 * playlistid command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * <p>
 *     This command's response contains metadata of a queued song.
 * </p>
 * @author jfraney
 */
public class PlaylistId extends AbstractCommand<QueuedSongInfoResponse> {
    /**
     * all songs in the playlist
     */
    public PlaylistId() {super();}

    /**
     * one song in the playlist
     * @param songId of the song of interest
     */
    public PlaylistId(Integer songId) { super(adapt(songId));}

    @Override
    public QueuedSongInfoResponse response(java.util.List<String> responseLines) {
        return new QueuedSongInfoResponse(responseLines);
    }
}

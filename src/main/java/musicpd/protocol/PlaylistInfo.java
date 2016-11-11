package musicpd.protocol;

/**
 * playlistinfo command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * <p>
 *     This command's response contains metadata of a queued song.
 * </p>
 * @author jfraney
 */
public class PlaylistInfo extends AbstractCommand<QueuedSongInfoResponse> {
    /**
     * @param songpos position of songs of interest
     */
    public PlaylistInfo(Integer ... songpos) {super(adapt(songpos));}

    /**
     * @param start position of range of songs of interest
     * @param end position of range of songs of interest
     */
    public PlaylistInfo(Integer start, Integer end) {super(new RangeParameter(start, end));}

    @Override
    public QueuedSongInfoResponse response(java.util.List<String> responseLines) {
        return new QueuedSongInfoResponse(responseLines);
    }
}

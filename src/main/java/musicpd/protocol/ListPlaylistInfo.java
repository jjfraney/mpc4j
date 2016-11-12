package musicpd.protocol;

/**
 * listplaylistinfo command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>MPD Document: Stored playlists.</a>
 * <p>
 *     On this command, mpd returns database metadata for each song on the named playlist.
 * </p>
 * @author jfraney
 */
public class ListPlaylistInfo extends AbstractCommand<DatabaseQueryResponse> {
    /**
     * @param name of playlist
     */
    public ListPlaylistInfo(String name) {
        super(adapt(name));
    }
    @Override
    public DatabaseQueryResponse response(java.util.List<String> responseLines) {
        return new DatabaseQueryResponse(responseLines);
    }
}

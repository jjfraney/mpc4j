package musicpd.protocol;

import com.github.jjfraney.mpc.AbstractCommand;
import com.github.jjfraney.mpc.DatabaseQueryResponse;

/**
 * listplaylistinfo command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>
 *     MPD Document: Stored playlists.</a>
 * <p>
 *     On this command, mpd returns database metadata for each song on the named playlist.
 * </p>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class ListPlaylistInfo extends AbstractCommand<DatabaseQueryResponse> {
    /**
     * @param name of playlist
     */
    public ListPlaylistInfo(final String name) {
        super(adapt(name));
    }
    @Override
    public DatabaseQueryResponse response(final java.util.List<String> responseLines, final String connectResponse) {
        return new DatabaseQueryResponse(responseLines, connectResponse);
    }
}

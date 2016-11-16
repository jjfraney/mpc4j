package musicpd.protocol;

import org.jjflyboy.mpc.AbstractCommand;
import org.jjflyboy.mpc.HealthResponse;

import java.util.stream.Collectors;

/**
 * listplaylist command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>
 *     MPD Document: Stored playlists.</a>
 * <p>
 *     On this command, mpd returns a list of files that comprise the named playlist.
 * </p>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class ListPlaylist extends AbstractCommand<ListPlaylist.Response> {
    /**
     * @param name of playlist
     */
    public ListPlaylist(final String name) {
        super(adapt(name));
    }

    @Override
    public Response response(final java.util.List<String> responseLines, final String connectResponse) {
        return new Response(responseLines, connectResponse);
    }

    /**
     * provides access to the list of file names returned by mpd by the listplaylist command.
     */
    public static class Response extends HealthResponse {
        Response(final java.util.List<String> responseLines, final String connectResponse) {
            super(responseLines, connectResponse);
        }

        private final static String HDR = "file: ";

        /**
         * access the response to get the file names of the playlist.
         * @return a list of file names.
         */
        public java.util.List<String> getFiles() {
            return getResponseLines().stream()
                    .filter(line -> line.startsWith(HDR))
                    .map(line -> line.substring(HDR.length(), line.length()))
                    .collect(Collectors.toList());
        }
    }
}

package musicpd.protocol;

import com.github.jjfraney.mpc.AbstractCommand;
import com.github.jjfraney.mpc.HealthResponse;
import com.github.jjfraney.mpc.ResponseContent;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * listplaylists command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>
 *     MPD Document: Control playback.</a>
 * <p>
 *     On this command, mpd returns a list of playlist names with their last modified date.
 * </p>
 s* @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class ListPlaylists extends AbstractCommand<ListPlaylists.Response> {

    @Override
    public Response response(final java.util.List<String> responseLines, final String connectResponse) {
        return new Response(responseLines, connectResponse);
    }

    public static class Response extends HealthResponse {
        Response(final java.util.List<String> responseLines, final String connectResponse) {
            super(responseLines, connectResponse);
        }

        public class Playlist extends ResponseContent {

            Playlist(final java.util.List<String> responseLines) {
                super(responseLines);
            }
            public Optional<String> getPlaylist() {return getStringValue("playlist");}
            public Optional<ZonedDateTime> getLastModified() {return getZonedDateTimeValue("Last-Modified");}
        }

        public java.util.List<Playlist> getPlaylists() {
            return segments("playlist")
                    .stream()
                    .map(Playlist::new)
                    .collect(Collectors.toList());
        }
    }
}

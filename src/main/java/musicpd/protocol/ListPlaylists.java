package musicpd.protocol;

import org.jjflyboy.mpc.AbstractCommand;
import org.jjflyboy.mpc.HealthResponse;
import org.jjflyboy.mpc.ResponseContent;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * listplaylists command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>MPD Document: Control playback.</a>
 * <p>
 *     On this command, mpd returns a list of playlist names with their last modified date.
 * </p>
 s* @author jfraney
 */
public class ListPlaylists extends AbstractCommand<ListPlaylists.Response> {
    public ListPlaylists() {
        super();
    }

    @Override
    public Response response(java.util.List<String> responseLines) {
        return new Response(responseLines);
    }

    public static class Response extends HealthResponse {
        Response(java.util.List<String> responseLines) {
            super(responseLines);
        }

        public class Playlist extends ResponseContent {

            Playlist(java.util.List<String> responseLines) {
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

package org.jjfflyboy.mpc4j;

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
    public Response response(String[] responseLines) {
        return new Response(responseLines);
    }

    public static class Response extends SimpleResponse {
        Response(String[] responseLines) {
            super(responseLines);
        }

        public class Playlist extends ResponseContent {

            Playlist(String[] responseLines) {
                super(responseLines);
            }
            public Optional<String> getPlaylist() {return getStringValue("playlist");}
            public Optional<ZonedDateTime> getLastModified() {return getZonedDateTimeValue("Last-Modified");}
        }

        public java.util.List<Playlist> getPlaylists() {
            return segments("playlist")
                    .stream()
                    .map(ls -> new Playlist(ls.toArray(new String[ls.size()])))
                    .collect(Collectors.toList());
        }
    }
}

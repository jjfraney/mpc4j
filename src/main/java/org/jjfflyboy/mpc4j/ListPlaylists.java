package org.jjfflyboy.mpc4j;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * @author jfraney
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
            return getSubResponse(Playlist.class);
        }
    }
}

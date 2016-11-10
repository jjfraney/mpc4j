package org.jjfflyboy.mpc4j;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * lsinfo command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>MPD Document: The music database.</a>
 * <p>
 *     On this command, mpd returns database metadata for each song.
 * </p>
 * @author jfraney
 */
public class LsInfo extends AbstractCommand<LsInfo.Response> {

    public LsInfo() {
        super();
    }

    // TODO: this command also returns a list of playlists
    @Override
    public Response response(String[] responseLines) {
        return new Response(responseLines);
    }

    public static class Response extends DatabaseSongInfoResponse {

        Response(String[] responseLines) {
            super(responseLines);
        }

        public class PlaylistInfo extends ResponseContent {

            PlaylistInfo(String[] responseLines) {
                super(responseLines);
            }

            public Optional<String> getPlaylist() {return getStringValue("playlist");}
            public Optional<ZonedDateTime> getLastModified() {return getZonedDateTimeValue("Last-Modified");}
        }

        @Override
        public java.util.List<DatabaseSongInfo> getSongInfo() {
            return segments("file", "playlist")
                    .stream()
                    .filter(seg -> isLabelMatch("file", seg.get(0)))
                    .map(l -> new DatabaseSongInfo(l.toArray(new String[l.size()])))
                    .collect(Collectors.toList());
        }

        public java.util.List<PlaylistInfo> getPlaylistInfo() {
           return segments("file", "playlist")
                   .stream()
                   .filter(seg -> isLabelMatch("playlist", seg.get(0)))
                    .map(l -> new PlaylistInfo(l.toArray(new String[l.size()])))
                 .collect(Collectors.toList());
        }
    }
}

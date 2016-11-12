package musicpd.protocol;

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
    public Response response(java.util.List<String> responseLines) {
        return new Response(responseLines);
    }

    public static class Response extends DatabaseQueryResponse {

        Response(java.util.List<String> responseLines) {
            super(responseLines);
        }

        public class PlaylistInfo extends ResponseContent {

            PlaylistInfo(java.util.List<String> responseLines) {
                super(responseLines);
            }

            public Optional<String> getPlaylist() {return getStringValue("playlist");}
            public Optional<ZonedDateTime> getLastModified() {return getZonedDateTimeValue("Last-Modified");}
        }

        @Override
        public java.util.List<DatabaseSongMetadata> getMetadata() {
            return segments("file", "playlist")
                    .stream()
                    .filter(seg -> isLabelMatch("file", seg.get(0)))
                    .map(DatabaseSongMetadata::new)
                    .collect(Collectors.toList());
        }

        public java.util.List<PlaylistInfo> getPlaylistInfo() {
           return segments("file", "playlist")
                   .stream()
                   .filter(seg -> isLabelMatch("playlist", seg.get(0)))
                    .map(PlaylistInfo::new)
                 .collect(Collectors.toList());
        }
    }
}

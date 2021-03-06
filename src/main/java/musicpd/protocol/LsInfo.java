package musicpd.protocol;

import com.github.jjfraney.mpc.AbstractCommand;
import com.github.jjfraney.mpc.DatabaseQueryResponse;
import com.github.jjfraney.mpc.ResponseContent;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * lsinfo command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>MPD Document: The music database.</a>
 * <p>
 *     On this command, mpd returns database metadata for each song.
 * </p>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class LsInfo extends AbstractCommand<LsInfo.Response> {

    // TODO: this command also returns a list of playlists
    @Override
    public Response response(final java.util.List<String> responseLines, final String connectResponse) {
        return new Response(responseLines, connectResponse);
    }

    public static class Response extends DatabaseQueryResponse {

        Response(final java.util.List<String> responseLines, final String connectResponse) {
            super(responseLines, connectResponse);
        }

        public class PlaylistInfo extends ResponseContent {

            PlaylistInfo(final java.util.List<String> responseLines) {
                super(responseLines);
            }

            public Optional<String> getPlaylist() {return getStringValue("playlist");}//NOPMD
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

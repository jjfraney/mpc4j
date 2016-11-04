package org.jjfflyboy.mpc4j;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * listplaylist command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>MPD Document: Control playback.</a>
 * <p>
 *     On this command, mpd returns a list of files that comprise the named playlist.
 * </p>
 * @author jfraney
 */
public class ListPlaylist extends AbstractCommand<ListPlaylist.Response> {
    /**
     * @param name of playlist
     */
    public ListPlaylist(String name) {
        super(adapt(name));
    }

    @Override
    public Response response(java.util.List<String> responseLines) {
        return new Response(responseLines);
    }

    /**
     * provides access to the list of file names returned by mpd by the listplaylist command.
     */
    public static class Response extends SimpleResponse {
        Response(java.util.List<String> responseLines) {
            super(responseLines);
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

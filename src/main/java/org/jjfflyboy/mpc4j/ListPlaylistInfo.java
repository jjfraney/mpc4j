package org.jjfflyboy.mpc4j;

/**
 * listplaylistinfo command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>MPD Document: Control playback.</a>
 * <p>
 *     On this command, mpd returns database metadata for each song on the named playlist.
 * </p>
 * @author jfraney
 */
public class ListPlaylistInfo extends AbstractCommand<DatabaseSongInfoResponse> {
    /**
     * @param name of playlist
     */
    public ListPlaylistInfo(String name) {
        super(adapt(name));
    }
    @Override
    public DatabaseSongInfoResponse response(String[] responseLines) {
        return new DatabaseSongInfoResponse(responseLines);
    }
}

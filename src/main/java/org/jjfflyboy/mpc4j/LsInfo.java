package org.jjfflyboy.mpc4j;

/**
 * lsinfo command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>MPD Document: The music database.</a>
 * <p>
 *     On this command, mpd returns database metadata for each song.
 * </p>
 * @author jfraney
 */
public class LsInfo extends AbstractCommand<DatabaseSongInfoResponse> {

    public LsInfo() {
        super();
    }

    // TODO: this command also returns a list of playlists
    @Override
    public DatabaseSongInfoResponse response(String[] responseLines) {
        return new DatabaseSongInfoResponse(responseLines);
    }
}

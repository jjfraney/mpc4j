package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class ListPlaylistInfo extends AbstractCommand<DatabaseSongInfoResponse> {
    public ListPlaylistInfo(String name) {
        super(adapt(name));
    }
    @Override
    public DatabaseSongInfoResponse response(String[] responseLines) {
        return new DatabaseSongInfoResponse(responseLines);
    }
}

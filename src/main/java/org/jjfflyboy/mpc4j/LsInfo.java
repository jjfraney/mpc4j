package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class LsInfo extends AbstractCommand<DatabaseSongInfoResponse> {

    public LsInfo() {
        super();
    }
    @Override
    public DatabaseSongInfoResponse response(String[] responseLines) {
        return new DatabaseSongInfoResponse(responseLines);
    }
}

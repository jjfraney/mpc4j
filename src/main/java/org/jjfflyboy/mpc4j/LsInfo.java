package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class LsInfo implements Command<DatabaseSongInfoResponse> {
    @Override
    public String text() {
        return "lsinfo";
    }

    @Override
    public DatabaseSongInfoResponse response(String[] responseLines) {
        return new DatabaseSongInfoResponse(responseLines);
    }
}

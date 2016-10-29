package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class LsInfo extends Simple {

    public LsInfo() {
        super();
    }
    @Override
    public DatabaseSongInfoResponse response(String[] responseLines) {
        return new DatabaseSongInfoResponse(responseLines);
    }
}

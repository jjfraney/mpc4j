package org.jjfflyboy.mpc4j;

/**
 * response of commands to search the database for song info.
 * @author jfraney
 */
public class DatabaseSongInfoResponse extends SongInfoResponse {
    DatabaseSongInfoResponse(String[] responseLines) {
        super(responseLines);
    }

    /**
     * song info returned by database commands
     */
    public class DatabaseSongInfo extends SongInfo {

        /**
         * @param responseLines limited to a single song
         */
        protected DatabaseSongInfo(String[] responseLines) {
            super(responseLines);
        }

        // currently, there is not a distinction between this song info and
        // the abstract song info.  The existence of this song info class
        // helps to conceptualize the different song info from database and
        // play list commands.
    }

    /**
     * @return a list of song info from the response.
     */
    public java.util.List<DatabaseSongInfo> getSongInfo() {return getSongInfo(DatabaseSongInfo.class);}
}

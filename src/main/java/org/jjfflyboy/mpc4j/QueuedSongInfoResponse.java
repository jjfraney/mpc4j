package org.jjfflyboy.mpc4j;

import java.util.Optional;

/**
 * response of commands to search the playlist queue for song info.
 * @author jfraney
 */
public class QueuedSongInfoResponse extends SongInfoResponse {
    QueuedSongInfoResponse(String[] responseLines) {
        super(responseLines);
    }

    /**
     * song info returned by playlist commands
     */
    public class QueuedSongInfo extends SongInfo {

        /**
         * @param responseLines limited to a single song
         */
        protected QueuedSongInfo(String[] responseLines) {
            super(responseLines);
        }

        /**
         * get the song position
         * @return the value in the response line: 'Pos'
         */
        public Optional<Integer> getPos() {
            return getIntegerValue("Pos");
        }

        /**
         * get the song id.
         * @return the value in the response line: 'Id'
         */
        public Optional<Integer> getId() {
            return getIntegerValue("Id");
        }

    }

    /**
     * @return a list of song info from the response.
     */
    public java.util.List<QueuedSongInfo> getSongInfo() {return getSongInfo(QueuedSongInfo.class);}
}

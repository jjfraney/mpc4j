package org.jjfflyboy.mpc4j;

import java.util.Optional;

/**
 * Parse responses from database query commands.
 * <p>
 *     This class parses the lines for the song 'metadata' returned
 *     by commands in the 'datatbase' category.  This category is
 *     distinct from the 'queue' category
 *     (see @{link org.jjfflyboy.mpc4j.QueuedSongInfoResponse}).
 * </p>
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

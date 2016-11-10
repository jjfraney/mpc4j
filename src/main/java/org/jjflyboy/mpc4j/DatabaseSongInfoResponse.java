package org.jjflyboy.mpc4j;

import java.util.stream.Collectors;

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
public class DatabaseSongInfoResponse extends SongInfoResponse {
    DatabaseSongInfoResponse(java.util.List<String> responseLines) {
        super(responseLines);
    }

    /**
     * song info returned by database commands
     */
    public class DatabaseSongInfo extends SongInfo {

        /**
         * @param responseLines limited to a single song
         */
        protected DatabaseSongInfo(java.util.List<String> responseLines) {
            super(responseLines);
        }

        // currently, there is not a distinction between this song info and
        // the abstract song info.  The existence of this song info class
        // helps to conceptualize the different song info from database and
        // play list commands.
    }

    @Override
    public java.util.List<DatabaseSongInfo> getSongInfo() {
        return segments("file")
                .stream()
                .map(DatabaseSongInfo::new)
                .collect(Collectors.toList());
    }
}

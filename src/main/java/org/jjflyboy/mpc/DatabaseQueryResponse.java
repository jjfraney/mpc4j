package org.jjflyboy.mpc;

import java.util.stream.Collectors;

/**
 * Parse responses from database query commands.
 * <p>
 *     This class parses the lines for the song 'metadata' returned
 *     by commands in the 'datatbase' category.  This category is
 *     distinct from the 'queue' category
 *     (see {@link QueueQueryResponse}).
 * </p>
 * @author jfraney
 */
public class DatabaseQueryResponse extends HealthResponse {
    public DatabaseQueryResponse(java.util.List<String> responseLines) {
        super(responseLines);
    }

    /**
     * song info returned by database commands
     */
    public class DatabaseSongMetadata extends SongMetadata {

        /**
         * @param responseLines limited to a single song
         */
        public DatabaseSongMetadata(java.util.List<String> responseLines) {
            super(responseLines);
        }

        // currently, there is not a distinction between this song info and
        // the abstract song info.  The existence of this song info class
        // helps to conceptualize the different song info from database and
        // play list commands.
    }

    public java.util.List<DatabaseSongMetadata> getMetadata() {
        return segments("file")
                .stream()
                .map(DatabaseSongMetadata::new)
                .collect(Collectors.toList());
    }
}

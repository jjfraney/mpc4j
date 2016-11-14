package org.jjflyboy.mpc;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Parse responses from database query commands.
 * <p>
 *     This class parses the lines for the song 'metadata' returned
 *     by commands in the 'playlist' or 'queue' category.  This category is
 *     distinct from the 'database' category
 *     (see {@link DatabaseQueryResponse}).
 * </p>
 * @author jfraney
 */
public class QueueQueryResponse extends HealthResponse {
    protected QueueQueryResponse(java.util.List<String> responseLines) {
        super(responseLines);
    }

    /**
     * song info returned by playlist commands
     */
    public class QueuedSongMetadata extends SongMetadata {

        /**
         * @param responseLines limited to a single song
         */
        protected QueuedSongMetadata(java.util.List<String> responseLines) {
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

    public java.util.List<QueuedSongMetadata> getSongMetadata() {
            return segments("file")
                    .stream()
                    .map(QueuedSongMetadata::new)
                    .collect(Collectors.toList());
    }
}

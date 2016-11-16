package com.github.jjfraney.mpc;

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
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class QueueQueryResponse extends HealthResponse {
    protected QueueQueryResponse(final java.util.List<String> responseLines, final String connectResponse) {
        super(responseLines, connectResponse);
    }

    /**
     * song info returned by playlist commands
     */
    public class QueuedSongMetadata extends SongMetadata {

        /**
         * @param responseLines limited to a single song
         */
        protected QueuedSongMetadata(final java.util.List<String> responseLines) {
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

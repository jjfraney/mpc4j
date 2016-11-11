package musicpd.protocol;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

/**
 * response of commands that return song info
 * @author jfraney
 */
public abstract class SongInfoResponse extends SimpleResponse {

    SongInfoResponse(List<String> responseLines) {
        super(responseLines);
    }

    /**
     * the info of a single song in the database response lines.
     */
    public abstract class SongInfo extends ResponseContent {
        /**
         * @param responseLines limited to a single song
         */
        protected SongInfo(List<String> responseLines) {
            super(responseLines);
        }

        /**
         * @return the value in the response line: 'file'
         */
        public Optional<String> getFile() {
            return getStringValue("file");
        }

        /**
         * @return the value in the response line: 'RangeParameter'
         */
        public Optional<String> getRange() {
            return getStringValue("RangeParameter");
        }

        /**
         * @return the value for the response line: 'Last-Modified'
         */
        public Optional<ZonedDateTime> getLastModified() {
            return getZonedDateTimeValue("Last-Modified");
        }

        /**
         * @return the value for the response line: 'Time'
         */
        public Optional<Integer> getTime() {
            return getIntegerValue("Time");
        }

        /**
         * @param tag
         * @return the value in the response line with the tag.
         */
        public Optional<String> getTag(Tag tag) {
            return getStringValue(tag.toSongLabel());
        }
    }

    /**
     * Isolates the response lines into distinct Songs.
     *
     * @return a list of the 'songs' identified in the response.
     */
    protected abstract  <T extends SongInfo> List<T> getSongInfo();
}

package musicpd.protocol;

import java.time.ZonedDateTime;
import java.util.*;

/**
 * the metatdata in the response of a database or playlist query.
 * @author jfraney
 */
public abstract class SongMetadata extends ResponseContent {
    /**
     * @param responseLines limited to a single song
     */
    protected SongMetadata(java.util.List<String> responseLines) {
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

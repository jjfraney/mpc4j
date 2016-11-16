package com.github.jjfraney.mpc;

import musicpd.protocol.Tag;

import java.time.ZonedDateTime;
import java.util.*;

/**
 * the metatdata in the response of a database or playlist query.
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public abstract class SongMetadata extends ResponseContent {
    /**
     * @param responseLines limited to a single song
     */
    protected SongMetadata(final List<String> responseLines) {
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
     * @param tag to search in the response.
     * @return the value in the response line with the tag.
     */
    public Optional<String> getTag(final Tag tag) {
        return getStringValue(tag);
    }
}

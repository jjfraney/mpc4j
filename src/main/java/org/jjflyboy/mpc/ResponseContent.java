package org.jjflyboy.mpc;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * base class for holding and parsing a complete or a segment of response content.
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public abstract class ResponseContent {

    private final List<String> responseLines;
    protected ResponseContent(final List<String> responseLines) {
        final List<String> lines = new ArrayList<>(responseLines);
        this.responseLines = Collections.unmodifiableList(lines);
    }

    /**
     * Each line of the response has form 'name: value'.
     * @return the lines of content as unmodifiable list of String.
     */
    public List<String> getResponseLines() {
        return responseLines;
    }

    /**
     * @param name of field of interest
     * @return the value, as String, of the first field in this response with 'name', if present.
     */
    protected Optional<String> findFieldValue(final String name) {
        return ResponseContentParser.findFieldValue(getResponseLines(), name);
    }

    /**
     * @param name of field of interest
     * @return the value, as Integer, of the first field in this response with 'name', if present.
     */
    protected Optional<Integer> getIntegerValue(final String name) {
        return ResponseContentParser.getIntegerValue(getResponseLines(), name);
    }

    /**
     * @param name of field of interest
     * @return the value, as Integer, of the first field in this response with 'name', if present.
     */
    protected Optional<Long> getLongValue(final String name) {
        return ResponseContentParser.getLongValue(getResponseLines(), name);
    }

    /**
     * @param name of field of interest
     * @return the value, as Toggle, of the first field in this response with 'name', if present.
     */
    protected Optional<Toggle> getToggleValue(final String name) {
        return ResponseContentParser.getToggleValue(getResponseLines(), name);
    }

    /**
     * @param name of field of interest
     * @return the value, as BigDecimal, of the first field in this response with 'name', if present.
     */
    protected Optional<BigDecimal> getBigDecimalValue(final String name) {
        return ResponseContentParser.getBigDecimalValue(getResponseLines(), name);
    }

    /**
     * @param name of field of interest
     * @return the value, as ZonedDateTime, of the first field in this response with 'name', if present.
     */
    protected Optional<ZonedDateTime> getZonedDateTimeValue(final String name) {
        return ResponseContentParser.getZonedDateTimeValue(getResponseLines(), name);
    }

    /**
     * @param name of field of interest
     * @return the value, as String, of the first field in this response with 'name', if present.
     */
    protected Optional<String> getStringValue(final String name) {
        return ResponseContentParser.getStringValue(getResponseLines(), name);
    }
    /**
     * @param metatdata of field of interest
     * @return the value, as String, of the first field in this response with 'name', if present.
     */
    protected Optional<String> getStringValue(final ResponseContentParser.LineMetadata metatdata) {
        return ResponseContentParser.getStringValue(getResponseLines(), metatdata);
    }

    /**
     * @param name of field of interest
     * @return the value, as List<String>, of the first field in this response with 'name', if present.
     */
    protected List<String> getListOfStringValue(final String name) {
        return ResponseContentParser.getListOfStringValue(getResponseLines(), name);
    }

    /**
     * separates this response into segments..
     * @see ResponseContentParser#segments
     * @param markers - some labels, any marks the first line of a segment
     * @return segments....each begins with one of markers
     */
    protected List<List<String>> segments(final String ... markers) {
        return ResponseContentParser.segments(getResponseLines(), markers);
    }
    /**
     * separates this response into segments.
     * @see ResponseContentParser#segments
     * @param metadata - some labels, any marks the first line of a segment
     * @return segments....each begins with one of metadata
     */
    protected List<List<String>> segments(final ResponseContentParser.LineMetadata ... metadata) {
        return ResponseContentParser.segments(getResponseLines(), metadata);
    }
    /**
     * @param label to check for
     * @param line to check
     * @return true if the line starts with the given label
     */
    protected boolean isLabelMatch(final String label, final String line) {
        return ResponseContentParser.isLabelMatch(label, line);
    }
    /**
     * @param metadata to check for
     * @param line to check
     * @return true if the line starts with the given label
     */
    protected boolean isLabelMatch(final ResponseContentParser.LineMetadata metadata, final String line) {
        return ResponseContentParser.isLabelMatch(metadata, line);
    }
}

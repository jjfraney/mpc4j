package musicpd.protocol;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.List;

/**
 * base class for holding and parsing a complete or a segment of response content.
 * @author jfraney
 */
public abstract class ResponseContent {

    private final List<String> responseLines;
    ResponseContent(java.util.List<String> responseLines) {
        List<String> lines = new ArrayList<>(responseLines);
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
    protected Optional<String> findFieldValue(String name) {
        return ResponseContentParser.findFieldValue(getResponseLines(), name);
    }

    /**
     * @param name of field of interest
     * @return the value, as Integer, of the first field in this response with 'name', if present.
     */
    protected Optional<Integer> getIntegerValue(String name) {
        return ResponseContentParser.getIntegerValue(getResponseLines(), name);
    }

    /**
     * @param name of field of interest
     * @return the value, as Integer, of the first field in this response with 'name', if present.
     */
    protected Optional<Long> getLongValue(String name) {
        return ResponseContentParser.getLongValue(getResponseLines(), name);
    }

    /**
     * @param name of field of interest
     * @return the value, as Toggle, of the first field in this response with 'name', if present.
     */
    protected Optional<Toggle> getToggleValue(String name) {
        return ResponseContentParser.getToggleValue(getResponseLines(), name);
    }

    /**
     * @param name of field of interest
     * @return the value, as BigDecimal, of the first field in this response with 'name', if present.
     */
    protected Optional<BigDecimal> getBigDecimalValue(String name) {
        return ResponseContentParser.getBigDecimalValue(getResponseLines(), name);
    }

    /**
     * @param name of field of interest
     * @return the value, as ZonedDateTime, of the first field in this response with 'name', if present.
     */
    protected Optional<ZonedDateTime> getZonedDateTimeValue(String name) {
        return ResponseContentParser.getZonedDateTimeValue(getResponseLines(), name);
    }

    /**
     * @param name of field of interest
     * @return the value, as String, of the first field in this response with 'name', if present.
     */
    protected Optional<String> getStringValue(String name) {
        return ResponseContentParser.getStringValue(getResponseLines(), name);
    }

    /**
     * @param name of field of interest
     * @return the value, as List<String>, of the first field in this response with 'name', if present.
     */
    protected List<String> getListOfStringValue(String name) {
        return ResponseContentParser.getListOfStringValue(getResponseLines(), name);
    }

    /**
     * separates this response into segments.
     * @see ResponseContentParser#segments
     * @param markers - that identify the first line of each segment
     * @return
     */
    protected List<List<String>> segments(String ... markers) {
        return ResponseContentParser.segments(getResponseLines(), markers);
    }

    /**
     * @param label
     * @param line
     * @return true if the line starts with the given label
     */
    protected boolean isLabelMatch(String label, String line) {
        return ResponseContentParser.isLabelMatch(label, line);
    }
}

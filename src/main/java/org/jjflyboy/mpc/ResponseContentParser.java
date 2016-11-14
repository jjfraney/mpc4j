package org.jjflyboy.mpc;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility methods for 'parsing' mpd response lines.
 * @author jfraney
 */
public class ResponseContentParser {
    /**
     * @param responseLines to search
     * @param name of field of interest
     * @return the value of the first field in 'responseLines' with 'name', if present.
     */
    public static Optional<String> findFieldValue(java.util.List<String> responseLines, String name) {
        final String search = name + ": ";
        return responseLines.stream()
                .filter((x) -> x.startsWith(search))
                .findFirst()
                .map(f -> f.substring(search.length()))
                .filter(l -> l.trim().length() != 0);
    }

    /**
     * @param responseLines to search
     * @param name of field of interest
     * @return the value, as Integer, of the first field in 'responseLines' with 'name', if present.
     */
    public static Optional<Integer> getIntegerValue(List<String> responseLines, String name) {
        return findFieldValue(responseLines, name).map((s) -> Integer.decode(s));
    }

    /**
     * @param responseLines to search
     * @param name of field of interest
     * @return the value, as Long, of the first field in 'responseLines' with 'name', if present.
     */
    public static Optional<Long> getLongValue(List<String> responseLines, String name) {
        return findFieldValue(responseLines, name).map((s) -> Long.decode(s));
    }

    /**
     * @param responseLines to search
     * @param name of field of interest
     * @return the value, as Toggle, of the first field in 'responseLines' with 'name', if present.
     */
    public static Optional<Toggle> getToggleValue(List<String> responseLines, String name) {
        return findFieldValue(responseLines, name).map(s -> Toggle.decode(s));
    }

    /**
     * @param responseLines to search
     * @param name of field of interest
     * @return the value, as BigDecimal, of the first field in 'responseLines' with 'name', if present.
     */
    public static Optional<BigDecimal> getBigDecimalValue(List<String> responseLines, String name) {
        return findFieldValue(responseLines, name).map(s -> new BigDecimal(s));
    }

    /**
     * @param responseLines to search
     * @param name of field of interest
     * @return the value, as ZonedDateTime, of the first field in 'responseLines' with 'name', if present.
     */
    public static Optional<ZonedDateTime> getZonedDateTimeValue(List<String> responseLines, String name) {
        return findFieldValue(responseLines, name).map(s -> ZonedDateTime.parse(s, DateTimeFormatter.ISO_ZONED_DATE_TIME));
    }

    /**
     * @param responseLines to search
     * @param name of field of interest
     * @return the value, as String, of the first field in 'responseLines' with 'name', if present.
     */
    public static Optional<String> getStringValue(List<String> responseLines, String name) {
        return findFieldValue(responseLines, name);
    }
    /**
     * @param responseLines to search
     * @param metadata of field of interest
     * @return the value, as String, of the first field in 'responseLines' with 'name', if present.
     */
    public static Optional<String> getStringValue(List<String> responseLines, LineMetadata metadata) {
        return findFieldValue(responseLines, metadata.toLabel());
    }

    /**
     * @param responseLines to search
     * @param name of field of interest
     * @return the values, as List<String>, of the first field in 'responseLines' with 'name', if present.
     */
    public static List<String> getListOfStringValue(List<String> responseLines, String name) {
        return responseLines.stream()
                .filter(l -> l.startsWith(name + ": "))
                .map(l -> l.split(": "))
                .filter(s -> s.length == 2)
                .map(s -> s[1])
                .collect(Collectors.toList());
    }

    /**
     * separates response lines into segments.
     * <p>
     *     A list of response lines may be repeated.
     *     For example, a list of songs is a repeated list of responses.
     *     The fields are repeated while the values can be different.
     *     These repeated lines can be divided into separate lists.
     *     This is useful to process each segment individually
     *     as independent lists of string for parsing.
     * </p>
     * <p>
     *     When calling this method,
     *     we hope we have identified the correct label of the first line of each
     *     possible segment.
     *     The MPD protocol is not suited for this.
     *     The protocol does not use definitive separators.
     *     We make the following assumptions:
     *     <ul>
     *         <li>
     *             The order of fields is deterministic within a given MPD instance.
     *         </li>
     *         <li>
     *             The MPD server implementation doesn't change much.
     *         </li>
     *         <li>
     *             The MPD server source code is open to inspection.
     *         </li>
     *         <li>
     *             The MPD server's implementation can verified by observation with a tool such as netcap.
     *         </li>
     *     </ul>
     * </p>
     * @param responseLines to search
     * @param markers that identify the first line of each segment
     * @return list of identified segments in 'responseLines'
     */
    public static List<List<String>> segments(List<String> responseLines, java.util.List<String> markers) {
        List<List<String>> result = new ArrayList<>();
        List<String> segment = null;
        for(String line: responseLines) {
            if(line.startsWith("OK") || line.startsWith("ACK")) {
                continue;
            }

            Optional<String> match = markers.stream().filter(m -> isLabelMatch(m, line)).findFirst();
            if(match.isPresent()) {
                segment = new ArrayList<>();
                result.add(Collections.unmodifiableList(segment));
            }
            if(segment != null) {
                segment.add(line);
            }
        }
        return Collections.unmodifiableList(result);
    }
    /**
     * separates response lines into segments.
     *
     * @param responseLines to search
     * @param markers that identify the first line of each segment
     * @return list of identified segments in 'responseLines'
     */
    public static List<List<String>> segments(List<String> responseLines, String ... markers) {
        return segments(responseLines, Arrays.asList(markers));
    }

    /**
     * separates response lines into segments.
     *
     * @param responseLines to search
     * @param metadata that identify the first line of each segment
     * @return list of identified segments in 'responseLines'
     */
    public static List<List<String>> segments(List<String> responseLines, LineMetadata ... metadata) {
        java.util.List<String> m = Arrays.stream(metadata).map(LineMetadata::toLabel).collect(Collectors.toList());
        return segments(responseLines, m);
    }

    /**
     * determines whether a line has a required label.
     * @param label required
     * @param line to compare
     * @return true if the line has the required label
     */
    public static boolean isLabelMatch(String label, String line) {
        // match only: 'label: ' or 'label:'
        return (line.length() > label.length()
                    && line.charAt(label.length()) == ':')
                && (line.length() == label.length() + 1
                    || line.charAt(label.length() + 1) == ' ')
                && line.startsWith(label);
    }

    /**
     * determines whether a line has a required label.
     * @param metadata required
     * @param line to compare
     * @return true if the line has the label specified by metadata
     */
    public static boolean isLabelMatch(LineMetadata metadata, String line) {
        return isLabelMatch(metadata.toLabel(), line);
    }

    /**
     * Interface to describe any line in response data, for example, the line's label.
     * @see DatabaseQueryResponse
     * @see QueueQueryResponse
     * @author jfraney
     */
    public static interface LineMetadata {
        /**
         * returns the label of the response for this data.
         * @return
         */
        String toLabel();
    }
}

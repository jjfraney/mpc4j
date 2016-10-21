package org.jjfflyboy.mpc4j;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * access response content.  Provides common parse utilities.
 */
public abstract class ResponseContent {

    private final String[] responseLines;
    ResponseContent(String[] responseLines) {
        this.responseLines = responseLines;
    }

    public String[] getResponseLines() {
        return responseLines;
    }

    /**
     * @param name
     * @return an Optional for the value of the field referenced by 'name'
     */
    protected Optional<String> findFieldValue(String name) {
        final String search = name + ": ";
        return Stream.of(getResponseLines())
                .filter((x) -> x.startsWith(search))
                .findFirst()
                .map(f -> f.substring(search.length()));
    }

    protected Optional<Integer> getIntegerValue(String fieldName) {
        return findFieldValue(fieldName).map((s) -> Integer.decode(s));
    }
    protected Optional<Long> getLongValue(String fieldName) {
        return findFieldValue(fieldName).map((s) -> Long.decode(s));
    }
    protected Optional<Toggle> getToggleValue(String fieldName) {
        return findFieldValue(fieldName).map(s -> Toggle.decode(s));
    }

    protected Optional<BigDecimal> getBigDecimalValue(String fieldName) {
        return findFieldValue(fieldName).map(s -> new BigDecimal(s));
    }

    protected Optional<ZonedDateTime> getZonedDateTimeValue(String name) {
        return findFieldValue(name).map(s -> ZonedDateTime.parse(s, DateTimeFormatter.ISO_ZONED_DATE_TIME));
    }

    protected Optional<String> getStringValue(String fieldName) {
        return findFieldValue(fieldName);
    }

}

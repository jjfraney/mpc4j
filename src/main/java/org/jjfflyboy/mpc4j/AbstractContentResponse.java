package org.jjfflyboy.mpc4j;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Abstract class for Responses with content.  Provides common parse utilities.
 */
public abstract class AbstractContentResponse extends Simple.Response {

    AbstractContentResponse(String[] responseLines) {
        super(responseLines);
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

    protected Optional<Toggle> getToggleValue(String fieldName) {
        return findFieldValue(fieldName).map(s -> Toggle.decode(s));
    }

    protected Optional<BigDecimal> getBigDecimalValue(String fieldName) {
        return findFieldValue(fieldName).map(s -> new BigDecimal(s));
    }

    protected Optional<String> getStringValue(String fieldName) {
        return findFieldValue(fieldName);
    }

}

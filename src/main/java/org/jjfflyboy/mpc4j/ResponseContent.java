package org.jjfflyboy.mpc4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    protected boolean isOk() {
        return getResponseLines().length > 0
                &&  getResponseLines()[getResponseLines().length - 1].startsWith("OK");
    }

    /**
     * parses the last line as "ACK [error@commandListNum] {currentCommand} messageText"
     * @return an Ack, or if parse fails, null
     */
    protected Optional<Command.Response.Ack> getAck() {
        try {
            return Optional.of(new AckImpl(getResponseLines()[getResponseLines().length - 1]));
        } catch (RuntimeException e) {
            return Optional.ofNullable(null);
        }
    }

    public static class AckImpl implements Command.Response.Ack {
        // ACK [error@command_listNum] {current_command} message_text\n

        private static final Pattern PATTERN = Pattern.compile("ACK \\[(\\d*)@(\\d*)\\] \\{(.*)\\} (.*)");
        public AckImpl(String line) {
            Matcher m = PATTERN.matcher(line);
            if (m.matches()) {
                this.error = Integer.parseInt(m.group(1));
                this.commandListNum = Integer.parseInt(m.group(2));
                this.currentCommand = m.group(3);
                this.messageText = m.group(4);
            } else {
                throw new RuntimeException("bad parse");
            }
        }
        private Integer error;
        private Integer commandListNum;
        private String currentCommand;
        private String messageText;

        @Override
        public Integer getError() {
            return error;
        }

        @Override
        public Integer getCommandListNum() {
            return commandListNum;
        }

        @Override
        public String getCurrentCommand() {
            return currentCommand;
        }

        @Override
        public String getMessageText() {
            return messageText;
        }
    }

    /**
     * return a list of T objects.  The class of T must be a non-static nested in the response class because
     * the response lines do not exist outside of the response instance.
     * An assumption: the responseLines are a repeating series.
     * @param nested the class of objects to instantiate....must be nested by this ResponseContent
     * @param <T> the type of object to return
     * @return a list of objects found in the enclosing ResponseContent; empty if responseLines is empty.
     */
    protected <T extends ResponseContent> List<T> getSubResponse(Class<T> nested) {
        List<T> result = new ArrayList<>();

        String firstTag = null;
        if(getResponseLines().length > 0) {
            String[] s = getResponseLines()[0].split(":");
            firstTag = s[0];
        }

        // identify the indices that isolate each group of lines, by some first line
        String first = firstTag + ":";
        List<Integer> fileIndices = new ArrayList<>();
        for (int i = 0; i < getResponseLines().length; i++) {
            if (getResponseLines()[i].startsWith(first)) {
                fileIndices.add(i);
            }
        }

        // create a group for each set of lines between the indices
        for (int i = 0; i < fileIndices.size(); i++) {
            Integer startIndex = fileIndices.get(i);
            Integer endIndex = fileIndices.size() > i + 1 ? fileIndices.get(i + 1) : getResponseLines().length - 1;

            String[] responseLinesForSong = Arrays.copyOfRange(getResponseLines(), startIndex, endIndex);
            T object = newResourceContent(this, nested, responseLinesForSong);
            result.add(object);
        }
        return result;
    }
    private <T extends ResponseContent> T newResourceContent(Object enclosure, Class<T> clz, String[] responseLines) {
        try {
            Constructor[] ctors = clz.getConstructors();
            Constructor<T> ctor = clz.getDeclaredConstructor(enclosure.getClass(), String[].class);
            return ctor.newInstance(enclosure, responseLines);
        } catch (NoSuchMethodException e) {
            // there must be such a method because it is part of the ResponseContent abstraction!
            throw new RuntimeException(e);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // doubt it will ever happen.
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            // this is also under our control to prevent: we implement the ctors!
            throw new RuntimeException(e);
        }
    }
}

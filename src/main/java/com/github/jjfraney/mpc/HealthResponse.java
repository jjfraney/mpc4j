package com.github.jjfraney.mpc;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class to access the last line of every mpd response..
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public abstract class HealthResponse extends ResponseContent implements Command.Response {

    private final String connectResponse;

    /**
     * @param responseLines the lines of the command response
     * @param connectResponse the line of the connect response
     */
    protected HealthResponse(final java.util.List<String> responseLines, final String connectResponse) {
        super(responseLines);
        this.connectResponse = connectResponse;
    }

    public String getConnectResponse() {
        return connectResponse;
    }

    @Override
    public Optional<String> getProtocolVersion() {
        String version = null;
        if(connectResponse != null) {
            version = connectResponse.replace("OK MPD ", "");
        }
        return Optional.ofNullable(version);
    }

    /**
     * parses the last line to look for OK
     * <p>
     *     Each response of any command can end in 'OK'
     *     Each response segment of a 'command list' command ends in 'list_OK'.
     * </p>
     * @return true if last line contains "OK"
     */
    @Override
    public boolean isOk() {
        return getResponseLines().size() > 0
                &&  getResponseLines().get(getResponseLines().size() - 1).contains("OK");
    }

    /**
     * parses the last line as "ACK [error@commandListNum] {currentCommand} messageText"
     * @return an Ack, or if parse fails, null
     */
    @Override
    public Optional<Ack> getAck() {
        try {
            return Optional.of(new AckImpl(getResponseLines().get(getResponseLines().size() - 1)));
        } catch (final RuntimeException e) {
            return Optional.empty();
        }
    }



    class AckImpl implements Ack {
        // ACK [error@command_listNum] {current_command} message_text\n

        private final Pattern PATTERN = Pattern.compile("ACK \\[(\\d*)@(\\d*)\\] \\{(.*)\\} (.*)");
        public AckImpl(final String line) {
            final Matcher m = PATTERN.matcher(line);
            if (m.matches()) {
                this.error = Integer.parseInt(m.group(1));
                this.commandListNum = Integer.parseInt(m.group(2));
                this.currentCommand = m.group(3);
                this.messageText = m.group(4);
            } else {
                throw new MpcRuntimeException("bad parse");
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

}

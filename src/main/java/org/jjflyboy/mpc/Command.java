package org.jjflyboy.mpc;


import java.io.Serializable;
import java.util.Optional;

/**
 * A command and response of the MPD protocol.
 * <p>
 *     This interface encapsulates the protocol's text representation
 *     of commands and responses.  An implementation knows how to
 *     generate the command-text and parse the response-text per the mpd protocol.
 *     An implementation of 'Command' can define instance fields for command
 *     arguments. An implementation of 'Command.Response' can define instance
 *     fields for response data.
 * </p>
 * @author jfraney
 */
public interface Command<R extends Command.Response> extends Serializable {
    /**
     * gets the text for this command as conforms to mpd protocol, and any
     * parameters.  The intention is for implementations to provide the
     * parameters by way of private data members.
     * @return text representation of this command instance...with parameters if any.
     */
    String text();

    /**
     * @param responseLines given by mpd server in response to this command.
     * @param connectResponse of the MPD source of the response.
     * @return an actual Response to this Command.
     */
    R response(java.util.List<String> responseLines, String connectResponse);

    /**
     * An interface to access data of the response.  The intention is for
     * this interface to be extended for each command to access command specific responses.
     * Implementations of Response should be able to read the response lines for the
     * MPD protocol response fields and access their values.
     */
    interface Response extends Serializable {
        /**
         * @return all the lines of the response
         */
        java.util.List<String> getResponseLines();

        /**
         * @return the single line response on connect to MPD
         */
        String getConnectResponse();

        /**
         * @return the version of the protocol in use by the MPD.
         */
        Optional<String> getProtocolVersion();

        /**
         * get the response status from the last line of the response.
         * @return true if last line of the response starts with OK
         */
        boolean isOk();

        /**
         * parse the last line as if it were an ACK.
         * @return either the Ack object as below, or, if unable to parse the last line, null.
         */
        Optional<Ack> getAck();

        /**
         * represents the fields present in the ACK response line.
         */
        interface Ack {
            /**
             * @return an error number
             */
            Integer getError();

            /**
             * @return the command number if a multi-command request.
             */
            Integer getCommandListNum();

            /**
             * @return the spelling of the command that failed.
             */
            String getCurrentCommand();

            /**
             * @return the error text provided by the daemon.
             */
            String getMessageText();
        }
    }
}

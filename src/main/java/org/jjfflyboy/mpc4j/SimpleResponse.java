package org.jjfflyboy.mpc4j;

import java.util.Optional;

/**
 * gives access to the status in the command's response.
 * @author jfraney
 */
public class SimpleResponse extends ResponseContent implements Command.Response {

    SimpleResponse(java.util.List<String> responseLines) {
        super(responseLines);
    }

    @Override
    public boolean isOk() {
        return super.isOk();
    }

    @Override
    public Optional<Ack> getAck() {
        return super.getAck();
    }
}

package org.jjfflyboy.mpc4j;

import java.util.Optional;

/**
 * @author jfraney
 */
public class SimpleResponse extends ResponseContent implements Command.Response {

    SimpleResponse(String[] responseLines) {
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

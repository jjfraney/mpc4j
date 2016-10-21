package org.jjfflyboy.mpc4j;

import java.util.Optional;

/**
 * @author jfraney
 */
public abstract class Simple implements Command<Simple.Response> {


    @Override
    public Response response(String[] responseLines) {
        return new Response(responseLines);
    }
    public static class Response extends ResponseContent implements Command.Response {

        Response(String[] responseLines) {
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
}

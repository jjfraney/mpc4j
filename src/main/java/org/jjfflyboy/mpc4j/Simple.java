package org.jjfflyboy.mpc4j;

import java.util.Optional;

/**
 * @author jfraney
 */
public abstract class Simple extends AbstractCommand<Simple.Response> {

    /**
     * instantiate simple command.  The concrete class name, to lower case, is the command's spelling.
     * @param parameters
     */
    protected Simple(Parameter ... parameters) {
        super(parameters);
    }

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

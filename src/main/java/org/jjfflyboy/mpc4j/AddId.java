package org.jjfflyboy.mpc4j;

import java.util.Optional;

/**
 * addid command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * <p>
 *     This command resturns the added file's song id.
 * </p>

 * @author jfraney
 */
public class AddId extends Simple {
    public AddId(String uri) {
        super(adapt(uri));
    }
    public AddId(String uri, Integer pos) {
        super(adapt(uri), adapt(pos));
    }

    @Override
    public Response response(String[] responseLines) {
        return new Response(responseLines);
    }
    public static class Response extends SimpleResponse {
        public Response(String [] responseLines) {
            super(responseLines);
        }

        public Optional<Integer> getId() {return getIntegerValue("Id");}
    }
}

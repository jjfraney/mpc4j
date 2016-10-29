package org.jjfflyboy.mpc4j;

import java.util.Optional;

/**
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
    public static class Response extends Simple.Response {
        public Response(String [] responseLines) {
            super(responseLines);
        }

        public Optional<Integer> getId() {return getIntegerValue("Id");}
    }
}

package org.jjfflyboy.mpc4j;

import java.util.Optional;

/**
 * @author jfraney
 */
public class AddId extends Simple {
    private final String uri;
    private final Integer pos;
    public AddId(String uri) {
        this.uri = uri;
        this.pos = null;
    }
    public AddId(String uri, Integer pos) {
        this.uri = uri;
        this.pos = pos;
    }

    @Override
    public String text() {
        StringBuilder sb = new StringBuilder()
                .append("addid")
                .append(" ")
                .append(uri)
                ;
        if(pos != null) {
            sb.append(" ").append(pos);
        }
        return sb.toString();
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

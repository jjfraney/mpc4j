package org.jjfflyboy.mpc4j;

import java.util.Optional;

/**
 * @author jfraney
 */
public class PlChangesPosId implements Command<PlChangesPosId.Response> {


    private final Integer version;
    public PlChangesPosId(Integer version) {
        this.version = version;
    }
    @Override
    public String text() {
        return "plchangesposid " + version;
    }

    @Override
    public Response response(String[] responseLines) {
        return new Response(responseLines);
    }

    public class Response extends Simple.Response {
        Response(String[] responseLines) {
            super(responseLines);
        }

        public class Entry extends ResponseContent {

            Entry(String[] responseLines) {
                super(responseLines);
            }

            public Optional<Integer> getCpos() {
                return getIntegerValue("cpos");
            }

            public Optional<Integer> getId() {
                return getIntegerValue("Id");
            }
        }
        public java.util.List<Entry> getEntries() {
            return getSubResponse(Entry.class);
        }
    }
}

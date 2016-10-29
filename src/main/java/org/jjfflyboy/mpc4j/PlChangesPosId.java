package org.jjfflyboy.mpc4j;

import java.util.Optional;

/**
 * @author jfraney
 */
public class PlChangesPosId extends AbstractCommand<PlChangesPosId.Response> {


    public PlChangesPosId(Integer version) {
        super(adapt(version));
    }

    @Override
    public Response response(String[] responseLines) {
        return new Response(responseLines);
    }

    public class Response extends SimpleResponse {
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

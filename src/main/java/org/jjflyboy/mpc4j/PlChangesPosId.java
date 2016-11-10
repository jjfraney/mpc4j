package org.jjflyboy.mpc4j;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * plchangesposid command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * <p>
 *     This command's response contains the new position, and id for each changed song.
 * </p>
 * @author jfraney
 */
public class PlChangesPosId extends AbstractCommand<PlChangesPosId.Response> {


    /**
     * @param version to compare with
     */
    public PlChangesPosId(Integer version) {
        super(adapt(version));
    }

    @Override
    public Response response(java.util.List<String> responseLines) {
        return new Response(responseLines);
    }

    public class Response extends SimpleResponse {
        Response(java.util.List<String> responseLines) {
            super(responseLines);
        }

        public class Entry extends ResponseContent {

            Entry(java.util.List<String> responseLines) {
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
            return segments("cpos")
                    .stream()
                    .map(ls -> new Entry(ls))
                    .collect(Collectors.toList());
        }
    }
}

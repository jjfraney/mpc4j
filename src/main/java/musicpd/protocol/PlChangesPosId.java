package musicpd.protocol;

import org.jjflyboy.mpc.AbstractCommand;
import org.jjflyboy.mpc.HealthResponse;
import org.jjflyboy.mpc.ResponseContent;

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
    public Response response(java.util.List<String> responseLines, String connectResponse) {
        return new Response(responseLines, connectResponse);
    }

    public class Response extends HealthResponse {
        Response(java.util.List<String> responseLines, String connectResponse) {
            super(responseLines, connectResponse);
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

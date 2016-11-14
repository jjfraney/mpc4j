package musicpd.protocol;

import org.jjflyboy.mpc.AbstractCommand;
import org.jjflyboy.mpc.HealthResponse;

import java.util.Optional;

/**
 * addid command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * <p>
 *     This command resturns the added file's song id.
 * </p>

 * @author jfraney
 */
public class AddId extends AbstractCommand<AddId.Response> {
    /**
     * @param uri song file location
     */
    public AddId(String uri) {
        super(adapt(uri));
    }

    /**
     * @param uri song file location
     * @param pos position of the added song
     */
    public AddId(String uri, Integer pos) {
        super(adapt(uri), adapt(pos));
    }

    @Override
    public Response response(java.util.List<String> responseLines) {
        return new Response(responseLines);
    }
    public static class Response extends HealthResponse {
        public Response(java.util.List<String> responseLines) {
            super(responseLines);
        }

        public Optional<Integer> getId() {return getIntegerValue("Id");}
    }
}

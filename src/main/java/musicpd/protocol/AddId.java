package musicpd.protocol;

import org.jjflyboy.mpc.AbstractCommand;
import org.jjflyboy.mpc.HealthResponse;

import java.util.Optional;

/**
 * addid command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>
 *     MPD Document: The current playlist.
 * </a>
 * <p>This command returns the added file's song id.</p>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class AddId extends AbstractCommand<AddId.Response> {
    /**
     * @param uri song file location
     */
    public AddId(final String uri) {
        super(adapt(uri));
    }

    /**
     * @param uri song file location
     * @param pos position of the added song
     */
    public AddId(final String uri, final Integer pos) {
        super(adapt(uri), adapt(pos));
    }

    /**
     * @param responseLines given by mpd server in response to this command.
     * @param connectResponse of the MPD source of the response.
     * @return addid response
     */
    @Override
    public Response response(final java.util.List<String> responseLines, final String connectResponse) {
        return new Response(responseLines, connectResponse);
    }

    /**
     * The addid response.
     */
    public static class Response extends HealthResponse {
        public Response(final java.util.List<String> responseLines, final String connectResponse) {
            super(responseLines, connectResponse);
        }

        /**
         * @return the value for the line with the label 'id'
         */
        public Optional<Integer> getId() {return getIntegerValue("Id");}
    }
}

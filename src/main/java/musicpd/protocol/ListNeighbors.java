package musicpd.protocol;

import org.jjflyboy.mpc.AbstractCommand;
import org.jjflyboy.mpc.HealthResponse;
import org.jjflyboy.mpc.ResponseContent;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * listneighbors command from
 * <a href='https://www.musicpd.org/doc/protocol/mount.html'>MPD Document: Mounts and neighbors.</a>
 * <p>
 *     On this command, mpd returns a list of files and directories.
 * </p>
 * @author jfraney
 */
public class ListNeighbors extends AbstractCommand<ListNeighbors.Response> {
    public ListNeighbors() {
        super();
    }

    @Override
    public Response response(java.util.List<String> responseLines) {
        return new Response(responseLines);
    }

    /**
     * provides access to the list of file names returned by mpd by the listplaylist command.
     */
    public static class Response extends HealthResponse {
        Response(java.util.List<String> responseLines) {
            super(responseLines);
        }

        public class Neighbor extends ResponseContent {
            Neighbor(java.util.List<String> responseLines) {
                super(responseLines);
            }

            /**
             * @return value of neighbor label
             */
            public Optional<String> getNeighbor() {return getStringValue("neighbor");}
            /**
             * @return value of name label
             */
            public Optional<String> getName() {return getStringValue("name");}
        }
        /**
         * access the response to get the neighbors from the response.
         * @return a list of neighbors.
         */
        public java.util.List<Neighbor> getNeighbors() {
            return segments("neighbor").stream()
                    .map(sg -> new Neighbor(sg))
                    .collect(Collectors.toList());
        }
    }
}

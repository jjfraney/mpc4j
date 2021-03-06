package musicpd.protocol;

import com.github.jjfraney.mpc.AbstractCommand;
import com.github.jjfraney.mpc.HealthResponse;
import com.github.jjfraney.mpc.ResponseContent;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * listneighbors command from
 * <a href='https://www.musicpd.org/doc/protocol/mount.html'>
 *     MPD Document: Mounts and neighbors.</a>
 * <p>
 *     On this command, mpd returns a list of files and directories.
 * </p>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class ListNeighbors extends AbstractCommand<ListNeighbors.Response> {

    @Override
    public Response response(final java.util.List<String> responseLines, final String connectResponse) {
        return new Response(responseLines, connectResponse);
    }

    /**
     * provides access to the list of file names returned by mpd by the listplaylist command.
     */
    public static class Response extends HealthResponse {
        Response(final java.util.List<String> responseLines, final String connectResponse) {
            super(responseLines, connectResponse);
        }

        public class Neighbor extends ResponseContent {
            Neighbor(final java.util.List<String> responseLines) {
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
                    .map(Neighbor::new)
                    .collect(Collectors.toList());
        }
    }
}

package musicpd.protocol;

import org.jjflyboy.mpc.AbstractCommand;
import org.jjflyboy.mpc.HealthResponse;
import org.jjflyboy.mpc.ResponseContent;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * listmounts command from
 * <a href='https://www.musicpd.org/doc/protocol/mount.html'>
 *     MPD Document: Mounts and neighbors.</a>
 * <p>
 *     On this command, mpd returns a list of files and directories.
 * </p>
 * @author jfraney
 */
public class ListMounts extends AbstractCommand<ListMounts.Response> {

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

        public class Mount extends ResponseContent {
            Mount(final java.util.List<String> responseLines) {
                super(responseLines);
            }

            /**
             * @return value of storage label
             */
            public Optional<String> getStorage() {return getStringValue("storage");}
            /**
             * @return value of mount label
             */
            public Optional<String> getMount() {return getStringValue("mount");}
        }
        /**
         * access the response to get the mounts from the response.
         * @return a list of mounts.
         */
        public java.util.List<Mount> getMounts() {
            return segments("mount").stream()
                    .map(Mount::new)
                    .collect(Collectors.toList());
        }
    }
}

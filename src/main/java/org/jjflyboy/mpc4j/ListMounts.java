package org.jjflyboy.mpc4j;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * listmounts command from
 * <a href='https://www.musicpd.org/doc/protocol/mount.html'>MPD Document: Mounts and neighbors.</a>
 * <p>
 *     On this command, mpd returns a list of files and directories.
 * </p>
 * @author jfraney
 */
public class ListMounts extends AbstractCommand<ListMounts.Response> {
    public ListMounts() {
        super();
    }

    @Override
    public Response response(java.util.List<String> responseLines) {
        return new Response(responseLines);
    }

    /**
     * provides access to the list of file names returned by mpd by the listplaylist command.
     */
    public static class Response extends SimpleResponse {
        Response(java.util.List<String> responseLines) {
            super(responseLines);
        }

        public class Mount extends ResponseContent {
            Mount(java.util.List<String> responseLines) {
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
                    .map(sg -> new Mount(sg))
                    .collect(Collectors.toList());
        }
    }
}

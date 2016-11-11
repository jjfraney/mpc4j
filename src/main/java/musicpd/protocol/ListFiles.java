package musicpd.protocol;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * listfiles command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>MPD Document: The music database.</a>
 * <p>
 *     On this command, mpd returns a list of files and directories.
 * </p>
 * @author jfraney
 */
public class ListFiles extends AbstractCommand<ListFiles.Response> {
    /**
     * @param uri of directory to list
     */
    public ListFiles(String uri) {
        super(adapt(uri));
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

        public class Entry extends ResponseContent {
            Entry(java.util.List<String> responseLines) {
                super(responseLines);
            }

            /**
             * @return value of directory label
             */
            public Optional<String> getDirectory() {return getStringValue("directory");}

            /**
             * @return value of file label
             */
            public Optional<String> getFile() {return getStringValue("file");}

            /**
             * @return true if a file label exists
             */
            public boolean isFile() {return getFile().isPresent();}

            /**
             * @return true if a directory label exists
             */
            public boolean isDirectory() {return getDirectory().isPresent();}

            /**
             * @return value of Last-Modified label
             */
            public Optional<ZonedDateTime> getLastModified() {return getZonedDateTimeValue("Last-Modified");}

            /**
             * @return value of size label
             */
            public Optional<Integer> getSize() { return getIntegerValue("size");}
        }
        /**
         * access the response to get the entries from the response.  An entry is either a 'file' or a 'directory'.
         * @return a list of entries.
         */
        public java.util.List<Entry> getEntries() {
            return segments("file", "directory").stream()
                    .map(sg -> new Entry(sg))
                    .collect(Collectors.toList());
        }
    }
}

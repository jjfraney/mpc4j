package musicpd.protocol;

import org.jjflyboy.mpc.AbstractCommand;
import org.jjflyboy.mpc.HealthResponse;
import org.jjflyboy.mpc.ResponseContent;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;

/**
 * listfiles command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>
 *     MPD Document: The music database.</a>
 * <p>
 *     On this command, mpd returns a list of files and directories.
 * </p>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class ListFiles extends AbstractCommand<ListFiles.Response> {
    /**
     * @param uri of directory to list
     */
    public ListFiles(final String uri) {
        super(adapt(uri));
    }

    @Override
    public Response response(final List<String> responseLines, final String connectResponse) {
        return new Response(responseLines, connectResponse);
    }

    /**
     * provides access to the list of file names returned by mpd by the listplaylist command.
     */
    public static class Response extends HealthResponse {
        Response(final List<String> responseLines, final String connectResponse) {
            super(responseLines, connectResponse);
        }

        public class Entry extends ResponseContent {
            Entry(final List<String> responseLines) {
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
        public List<Entry> getEntries() {
            return segments("file", "directory").stream()
                    .map(Entry::new)
                    .collect(Collectors.toList());
        }
    }
}

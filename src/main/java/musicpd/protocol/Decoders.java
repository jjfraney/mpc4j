package musicpd.protocol;

import org.jjflyboy.mpc.AbstractCommand;
import org.jjflyboy.mpc.HealthResponse;
import org.jjflyboy.mpc.ResponseContent;

import java.util.stream.Collectors;
import java.util.List;

/**
 * decoders command
 * from <a href='https://www.musicpd.org/doc/protocol/reflection_commands.html'>
 *     MPD document: Reflection</a>
 * @author jfraney
 */

public class Decoders extends AbstractCommand<Decoders.Response> {

    /**
     * response to decoders
     */
    public static class Response extends HealthResponse {
        Response(final java.util.List<String> responseLines, final String connectResponse) {
            super(responseLines, connectResponse);
        }

        /**
         * data for a decoder in response
         */
        public static class Plugin extends ResponseContent {
            Plugin(final List<String> responseLines) { super(responseLines);}

            /**
             * @return the value for the line with label 'suffix'
             */
            public List<String> getSuffixes() {
                return getListOfStringValue("suffix");
            }

            /**
             * @return the value for the line with the label 'mime_type'
             */
            public List<String> getMimeTypes() {
                return getListOfStringValue("mime_type");
             }
        }

        /**
         * @return list of decoders
         */
        public List<Plugin> getDecoders() {
            return segments("plugin")
                    .stream()
                    .map(Plugin::new)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public Response response(final java.util.List<String> responseLines, final String connectResponse) {
        return new Response(responseLines, connectResponse);
    }
}

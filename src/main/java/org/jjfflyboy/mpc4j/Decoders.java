package org.jjfflyboy.mpc4j;

import java.util.stream.Collectors;

/**
 * decoders command
 * from <a href='https://www.musicpd.org/doc/protocol/reflection_commands.html'>MPD document: Reflection</a>
 * @Author jfraney
 */

public class Decoders extends AbstractCommand<Decoders.Response> {

    public Decoders() {
        super();
    }

    public static class Response extends SimpleResponse {
        Response(java.util.List<String> responseLines) {
            super(responseLines);
        }

        public static class Plugin extends ResponseContent {
            Plugin(java.util.List<String> responseLines) { super(responseLines);}
            public java.util.List<String> getSuffixes() {
                return getListOfStringValue("suffix");
            }

            public java.util.List<String> getMimeTypes() {
                return getListOfStringValue("mime_type");
             }
        }
        public java.util.List<Plugin> getDecoders() {
            return segments("plugin")
                    .stream()
                    .map(Plugin::new)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public Response response(java.util.List<String> responseLines) {
        return new Response(responseLines);
    }
}

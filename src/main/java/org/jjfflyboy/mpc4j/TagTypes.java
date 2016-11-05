package org.jjfflyboy.mpc4j;

import java.util.stream.Collectors;

/**
 * tagtypes command
 * from <a href='https://www.musicpd.org/doc/protocol/reflection_commands.html'>MPD document: Reflection</a>
 * <p>
 *     The response of this command is list of strings (existing tagtypes).
 * </p>
 * @Author jfraney
 */

public class TagTypes extends AbstractCommand<TagTypes.Response> {

    public TagTypes() {
        super();
    }

    public static class Response extends SimpleResponse {
        Response(java.util.List<String> responseLines) {
            super(responseLines);
        }

        public java.util.List<String> getTagTypes() {
            return getResponseLines().stream()
                    .filter(l -> l.startsWith("tagtype: "))
                    .map(l -> l.split(": "))
                    .filter(s -> s.length == 2)
                    .map(s -> s[1])
                    .collect(Collectors.toList());
        }
    }

    @Override
    public Response response(java.util.List<String> responseLines) {
        return new Response(responseLines);
    }
}

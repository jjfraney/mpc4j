package org.jjfflyboy.mpc4j;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author jfraney
 */
public class ListPlaylist extends AbstractCommand<ListPlaylist.Response> {
    public ListPlaylist(String name) {
        super(adapt(name));
    }

    @Override
    public Response response(String[] responseLines) {
        return new Response(responseLines);
    }
    public static class Response extends SimpleResponse {
        Response(String[] responseLines) {
            super(responseLines);
        }

        private final static String HDR = "file: ";
        public java.util.List<String> getFiles() {
            return Arrays.stream(getResponseLines())
                    .filter(line -> line.startsWith(HDR))
                    .map(line -> line.substring(HDR.length(), line.length()))
                    .collect(Collectors.toList());
        }
    }
}

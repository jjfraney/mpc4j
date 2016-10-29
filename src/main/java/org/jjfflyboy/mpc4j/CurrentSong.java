package org.jjfflyboy.mpc4j;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * @author jfraney
 */
public class CurrentSong extends AbstractCommand<CurrentSong.Response> {

    public CurrentSong() {
        super();
    }

    public static class Response extends SimpleResponse {
        public Optional<String> getFile() {
            return getStringValue("file");
        }
        public Optional<ZonedDateTime> getLastModified() {return getZonedDateTimeValue("Last-Modified"); }
        public Optional<Integer> getTime() {return getIntegerValue("Time");}
        public Optional<Integer> getPosition() {return getIntegerValue("Pos");}
        public Optional<Integer> getId() {return getIntegerValue("Id");}

        Response(String[] responseLines) {
            super(responseLines);
        }
    }

    @Override
    public Response response(String[] responseLines) {
        return new Response(responseLines);
    }
}

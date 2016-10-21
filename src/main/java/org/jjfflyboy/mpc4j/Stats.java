package org.jjfflyboy.mpc4j;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * @author jfraney
 */
public class Stats implements Command<Stats.Response> {
    @Override
    public String text() {
        return "stats";
    }

    public static class Response extends Simple.Response {
        public Optional<Integer> getUptime() {return getIntegerValue("uptime");}
        public Optional<Integer> getPlaytime() {return getIntegerValue("playtime");}
        public Optional<Integer> getArtists() {return getIntegerValue("artists");}
        public Optional<Integer> getAlbums() {return getIntegerValue("albums");}
        public Optional<Integer> getSongs() {return getIntegerValue("songs");}
        public Optional<Integer> getDbPlaytime() {return getIntegerValue("db_playtime");}
        public Optional<Integer> getDbUpdate() {return getIntegerValue("db_update");}

        Response(String[] responseLines) {
            super(responseLines);
        }
    }

    @Override
    public Response response(String[] responseLines) {
        return new Response(responseLines);
    }
}

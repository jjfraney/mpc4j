package musicpd.protocol;

import java.util.Optional;

/**
 * stats command
 * from <a href='https://www.musicpd.org/doc/protocol/command_reference.html#status_commands'>MPD document</a>
 * <p>
 *     The response to this command is custom and contains several metrics of the database.
 * </p>
 * @Author jfraney
 */
public class Stats extends AbstractCommand<Stats.Response> {
    public Stats() {
        super();
    }

    /**
     * provides access to data in the response to 'stats' command.
     */
    public static class Response extends SimpleResponse {
        /**
         * @return value of 'uptime: ' line
         */
        public Optional<Integer> getUptime() {return getIntegerValue("uptime");}
        /**
         * @return value of 'playtime: ' line
         */
        public Optional<Integer> getPlaytime() {return getIntegerValue("playtime");}
        /**
         * @return value of 'artists: ' line
         */
        public Optional<Integer> getArtists() {return getIntegerValue("artists");}
        /**
         * @return value of 'albums: ' line
         */
        public Optional<Integer> getAlbums() {return getIntegerValue("albums");}
        /**
         * @return value of 'songs: ' line
         */
        public Optional<Integer> getSongs() {return getIntegerValue("songs");}
        /**
         * @return value of 'db_playtime: ' line
         */
        public Optional<Integer> getDbPlaytime() {return getIntegerValue("db_playtime");}
        /**
         * @return value of 'db_update: ' line
         */
        public Optional<Integer> getDbUpdate() {return getIntegerValue("db_update");}

        Response(java.util.List<String> responseLines) {
            super(responseLines);
        }
    }

    @Override
    public Response response(java.util.List<String> responseLines) {
        return new Response(responseLines);
    }
}

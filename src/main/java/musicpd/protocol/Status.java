package musicpd.protocol;

import org.jjflyboy.mpc.AbstractCommand;
import org.jjflyboy.mpc.HealthResponse;
import org.jjflyboy.mpc.Toggle;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * status command
 * from <a href='https://www.musicpd.org/doc/protocol/command_reference.html#status_commands'>MPD document</a>
 * <p>
 *     The response of this command is custom and contains the status of several playback controls.
 * </p>
 * @Author jfraney
 */

public class Status extends AbstractCommand<Status.Response> {

    public Status() {
        super();
    }

    /**
     * provides access to data in the response to 'status' command.
     */
    public static class Response extends HealthResponse {
        /**
         * @return value of 'volume: ' line
         */
        public Optional<Integer> getVolume() {
            return getIntegerValue("volume");
        }
        /**
         * @return value of 'repeat: ' line
         */
        public Optional<Toggle> getRepeat() {
            return getToggleValue("repeat");
        }
        /**
         * @return value of 'random: ' line
         */
        public Optional<Toggle> getRandom() {
            return getToggleValue("random");
        }
        /**
         * @return value of 'single: ' line
         */
        public Optional<Toggle> getSingle() {
            return getToggleValue("single");
        }
        /**
         * @return value of 'consume: ' line
         */
        public Optional<Toggle> getConsume() {
            return getToggleValue("consume");
        }
        /**
         * @return value of 'playlist: ' line
         */
        public Optional<Integer> getPlaylist() {
            return getIntegerValue("playlist");
        }
        /**
         * @return value of 'playlistlength: ' line
         */
        public Optional<Integer> getPlaylistLength() {
            return getIntegerValue("playlistlength");
        }
        /**
         * @return value of 'mixrampdb: ' line
         */
        public Optional<BigDecimal> getMixRampDb() {
            return getBigDecimalValue("mixrampdb");
        }
        /**
         * @return value of 'mixrampdelay: ' line
         */
        public Optional<BigDecimal> getMixRampDelay() {
            return getBigDecimalValue("mixrampdelay");
        }
        /**
         * @return value of 'updating_db: ' line
         */
        public Optional<Integer> getUpdatingDb() {
            return getIntegerValue("updating_db");
        }
        /**
         * @return value of 'state: ' line
         */
        public Optional<String> getState() {
            return getStringValue("state");
        }
        /**
         * @return value of 'error: ' line
         */
        public Optional<String> getError() {
            return getStringValue("error");
        }
        // these fields appear while state == 'play'
        /**
         * @return value of 'songid: ' line
         */
        public Optional<Integer> getSongId() {
            return getIntegerValue("songid");
        }
        /**
         * @return value of 'song: ' line
         */
        public Optional<Integer> getSong() {
            return getIntegerValue("song");
        }
        /**
         * @return value of 'nextsong: ' line
         */
        public Optional<Integer> getNextSong() {
            return getIntegerValue("nextsong");
        }
        /**
         * @return value of 'nextsongid: ' line
         */
        public Optional<Integer> getNextSongId() {
            return getIntegerValue("nextsongid");
        }
        /**
         * @return value of 'time: ' line
         */
        public Optional<String> getTime() {
            return getStringValue("time");
        }
        /**
         * @return value of 'elapsed: ' line
         */
        public Optional<BigDecimal> getElapsed() {
            return getBigDecimalValue("elapsed");
        }
        /**
         * @return value of 'bitrate: ' line
         */
        public Optional<Integer> getBitRate() {
            return getIntegerValue("bitrate");
        }

        /**
         * @return value of 'audio: ' line (in format "%u:%s:%u", "44100:16:2")
         */
        public Optional<String> getAudio() {
            return getStringValue("audio");
        }

        /**
         * @return value of 'xfade: ' line.
         */
        public Optional<Integer> getXfade() {
            return getIntegerValue("xfade");
        }

        /**
         * @param responseLines lines read from socket including 'OK' or 'ACK...."
         */
        Response(java.util.List<String> responseLines) {
            super(responseLines);
        }
    }

    /**
     * @param responseLines given by mpd server in response to this command.
     * @return access response data.
     */
    @Override
    public Response response(java.util.List<String> responseLines) {
        return new Response(responseLines);
    }
}

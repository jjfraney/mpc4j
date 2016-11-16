package musicpd.protocol;

import org.jjflyboy.mpc.Toggle;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class StatusTest {
    Status command;
    @Before
    public void setUp() {
        command = new Status();
    }

    @Test
    public void text()  {
        assertThat(command.text()).as("wrong command").isEqualTo("status");
    }

    @Test
    public void testResponseParse() {
        final java.util.List<String> responseText = Arrays.asList(
                "audio: anyAudio",
                "bitrate: 5500",
                "consume: 1",
                "error: any Error",
                "elapsed: 5.5",
                "mixrampdb: 9.900",
                "mixrampdelay: 10.3",
                "nextsong: 40",
                "nextsongid: 41",
                "playlist: 60",
                "playlistlength: 61",
                "random: 0",
                "repeat: 1",
                "single: 0",
                "state: any state",
                "song: 5",
                "songid: 3",
                "time: any time",
                "updating_db: 70",
                "volume: 30",
                "xfade: 99"
        );
        final Status.Response response = command.response(responseText, "OK MPD 0.19.0");
        assertThat(response.getAudio().orElse(null)).as("wrong parse").isEqualTo("anyAudio");
        assertThat(response.getBitRate().orElse(null).intValue()).as("wrong parse").isEqualTo(5500);
        assertThat(response.getConsume().orElse(null)).as("wrong parse").isEqualTo(Toggle.ON);
        assertThat(response.getError().orElse(null)).as("wrong parse").isEqualTo("any Error");
        assertThat(response.getElapsed().orElse(null)).as("wrong parse").isEqualTo(new BigDecimal("5.5"));
        assertThat(response.getMixRampDb().orElse(null)).as("wrong parse").isEqualTo(new BigDecimal("9.900"));
        assertThat(response.getMixRampDelay().orElse(null)).as("wrong parse").isEqualTo(new BigDecimal("10.3"));
        assertThat(response.getNextSong().orElse(null).intValue()).as("wrong parse").isEqualTo(40);
        assertThat(response.getNextSongId().orElse(null).intValue()).as("wrong parse").isEqualTo(41);
        assertThat(response.getPlaylist().orElse(null).intValue()).as("wrong parse").isEqualTo(60);
        assertThat(response.getPlaylistLength().orElse(null).intValue()).as("wrong parse").isEqualTo(61);
        assertThat(response.getRandom().orElse(null)).as("wrong parse").isEqualTo(Toggle.OFF);
        assertThat(response.getRepeat().orElse(null)).as("wrong parse").isEqualTo(Toggle.ON);
        assertThat(response.getSingle().orElse(null)).as("wrong parse").isEqualTo(Toggle.OFF);
        assertThat(response.getState().orElse(null)).as("wrong parse").isEqualTo("any state");
        assertThat(response.getSong().orElse(null).intValue()).as("wrong parse").isEqualTo(5);
        assertThat(response.getSongId().orElse(null).intValue()).as("wrong parse").isEqualTo(3);
        assertThat(response.getTime().orElse(null)).as("wrong parse").isEqualTo("any time");
        assertThat(response.getUpdatingDb().orElse(null).intValue()).as("wrong parse").isEqualTo(70);
        assertThat(response.getVolume().orElse(null).intValue()).as("wrong parse").isEqualTo(30);
        assertThat(response.getXfade().orElse(null).intValue()).as("wrong parse").isEqualTo(99);
        assertThat(response.getResponseLines().size()).as("untested property").isEqualTo(21);
    }
}
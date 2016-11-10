package org.jjflyboy.mpc4j;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jfraney
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
        java.util.List<String> responseText = Arrays.asList(
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
        Status.Response response = command.response(responseText);
        assertThat(response.getAudio().get()).as("wrong parse").isEqualTo("anyAudio");
        assertThat(response.getBitRate().get().intValue()).as("wrong parse").isEqualTo(5500);
        assertThat(response.getConsume().get()).as("wrong parse").isEqualTo(Toggle.ON);
        assertThat(response.getError().get()).as("wrong parse").isEqualTo("any Error");
        assertThat(response.getElapsed().get()).as("wrong parse").isEqualTo(new BigDecimal("5.5"));
        assertThat(response.getMixRampDb().get()).as("wrong parse").isEqualTo(new BigDecimal("9.900"));
        assertThat(response.getMixRampDelay().get()).as("wrong parse").isEqualTo(new BigDecimal("10.3"));
        assertThat(response.getNextSong().get().intValue()).as("wrong parse").isEqualTo(40);
        assertThat(response.getNextSongId().get().intValue()).as("wrong parse").isEqualTo(41);
        assertThat(response.getPlaylist().get().intValue()).as("wrong parse").isEqualTo(60);
        assertThat(response.getPlaylistLength().get().intValue()).as("wrong parse").isEqualTo(61);
        assertThat(response.getRandom().get()).as("wrong parse").isEqualTo(Toggle.OFF);
        assertThat(response.getRepeat().get()).as("wrong parse").isEqualTo(Toggle.ON);
        assertThat(response.getSingle().get()).as("wrong parse").isEqualTo(Toggle.OFF);
        assertThat(response.getState().get()).as("wrong parse").isEqualTo("any state");
        assertThat(response.getSong().get().intValue()).as("wrong parse").isEqualTo(5);
        assertThat(response.getSongId().get().intValue()).as("wrong parse").isEqualTo(3);
        assertThat(response.getTime().get()).as("wrong parse").isEqualTo("any time");
        assertThat(response.getUpdatingDb().get().intValue()).as("wrong parse").isEqualTo(70);
        assertThat(response.getVolume().get().intValue()).as("wrong parse").isEqualTo(30);
        assertThat(response.getXfade().get().intValue()).as("wrong parse").isEqualTo(99);
        assertThat(response.getResponseLines().size()).as("untested property").isEqualTo(21);
    }
}
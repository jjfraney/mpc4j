package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;

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
        Assert.assertEquals("wrong command", "status", command.text());
    }

    @Test
    public void testResponseParse() {
        String [] responseText = new String [] {
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
        };
        Status.Response response = command.response(responseText);
        Assert.assertEquals("wrong parse", "anyAudio", response.getAudio().get());
        Assert.assertEquals("wrong parse", 5500, response.getBitRate().get().intValue());
        Assert.assertEquals("wrong parse", Toggle.ON, response.getConsume().get());
        Assert.assertEquals("wrong parse", "any Error", response.getError().get());
        Assert.assertEquals("wrong parse", new BigDecimal("5.5"), response.getElapsed().get());
        Assert.assertEquals("wrong parse", new BigDecimal("9.900"), response.getMixRampDb().get());
        Assert.assertEquals("wrong parse", new BigDecimal("10.3"), response.getMixRampDelay().get());
        Assert.assertEquals("wrong parse", 40, response.getNextSong().get().intValue());
        Assert.assertEquals("wrong parse", 41, response.getNextSongId().get().intValue());
        Assert.assertEquals("wrong parse", 60, response.getPlaylist().get().intValue());
        Assert.assertEquals("wrong parse", 61, response.getPlaylistLength().get().intValue());
        Assert.assertEquals("wrong parse", Toggle.OFF, response.getRandom().get());
        Assert.assertEquals("wrong parse", Toggle.ON, response.getRepeat().get());
        Assert.assertEquals("wrong parse", Toggle.OFF, response.getSingle().get());
        Assert.assertEquals("wrong parse", "any state", response.getState().get());
        Assert.assertEquals("wrong parse", 5, response.getSong().get().intValue());
        Assert.assertEquals("wrong parse", 3, response.getSongId().get().intValue());
        Assert.assertEquals("wrong parse", "any time", response.getTime().get());
        Assert.assertEquals("wrong parse", 70, response.getUpdatingDb().get().intValue());
        Assert.assertEquals("wrong parse", 30, response.getVolume().get().intValue());
        Assert.assertEquals("wrong parse", 99, response.getXfade().get().intValue());
        Assert.assertEquals("untested property", 21, response.getResponseLines().length);
    }
}
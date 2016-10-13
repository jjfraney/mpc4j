package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Test;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author jfraney
 */
public class StatsTest {
    @Test
    public void text() {
        Assert.assertEquals("wrong command", "stats", new Stats().text());
    }

    @Test
    public void response() {
        Stats.Response r = new Stats().response(new String[] {
                "uptime: 10",
                "playtime: 20",
                "artists: 30",
                "albums: 40",
                "songs: 50",
                "db_playtime: 600",
                "db_update: 900"

        });
        Assert.assertEquals("wrong ", 10, r.getUptime().get().intValue());
        Assert.assertEquals("wrong ", 20, r.getPlaytime().get().intValue());
        Assert.assertEquals("wrong ", 30, r.getArtists().get().intValue());
        Assert.assertEquals("wrong ", 40, r.getAlbums().get().intValue());
        Assert.assertEquals("wrong ", 50, r.getSongs().get().intValue());
        Assert.assertEquals("wrong ", 600, r.getDbPlaytime().get().intValue());
        Assert.assertEquals("wrong ", 900L, r.getDbUpdate().get().longValue());
    }

}
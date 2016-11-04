package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Test;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class StatsTest {
    @Test
    public void text() {
        assertThat(new Stats().text()).as("wrong command").isEqualTo("stats");
    }

    @Test
    public void response() {
        Stats.Response r = new Stats().response(Arrays.asList(
                "uptime: 10",
                "playtime: 20",
                "artists: 30",
                "albums: 40",
                "songs: 50",
                "db_playtime: 600",
                "db_update: 900"

        ));
        assertThat(r.getUptime().get().intValue()).as("wrong ").isEqualTo(10);
        assertThat(r.getPlaytime().get().intValue()).as("wrong ").isEqualTo(20);
        assertThat(r.getArtists().get().intValue()).as("wrong ").isEqualTo(30);
        assertThat(r.getAlbums().get().intValue()).as("wrong ").isEqualTo(40);
        assertThat(r.getSongs().get().intValue()).as("wrong ").isEqualTo(50);
        assertThat(r.getDbPlaytime().get().intValue()).as("wrong ").isEqualTo(600);
        assertThat(r.getDbUpdate().get().longValue()).as("wrong ").isEqualTo(900L);
    }

}
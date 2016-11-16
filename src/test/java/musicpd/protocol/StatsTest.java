package musicpd.protocol;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class StatsTest {
    @Test
    public void text() {
        assertThat(new Stats().text()).as("wrong command").isEqualTo("stats");
    }

    @Test
    public void response() {
        final Stats.Response r = new Stats().response(Arrays.asList(
                "uptime: 10",
                "playtime: 20",
                "artists: 30",
                "albums: 40",
                "songs: 50",
                "db_playtime: 600",
                "db_update: 900"

        ), "OK MPD 0.19.0");
        assertThat(r.getUptime().orElse(null).intValue()).as("wrong ").isEqualTo(10);
        assertThat(r.getPlaytime().orElse(null).intValue()).as("wrong ").isEqualTo(20);
        assertThat(r.getArtists().orElse(null).intValue()).as("wrong ").isEqualTo(30);
        assertThat(r.getAlbums().orElse(null).intValue()).as("wrong ").isEqualTo(40);
        assertThat(r.getSongs().orElse(null).intValue()).as("wrong ").isEqualTo(50);
        assertThat(r.getDbPlaytime().orElse(null).intValue()).as("wrong ").isEqualTo(600);
        assertThat(r.getDbUpdate().orElse(null).longValue()).as("wrong ").isEqualTo(900L);
    }

}
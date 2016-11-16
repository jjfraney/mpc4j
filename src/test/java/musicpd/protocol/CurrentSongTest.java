package musicpd.protocol;

import org.jjflyboy.mpc.QueueQueryResponse;
import org.junit.Test;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class CurrentSongTest {
    @Test
    public void text() {
        assertThat(new CurrentSong().text()).as("wrong command").isEqualTo("currentsong");
    }

    @Test
    public void response() throws IOException {
        final ZonedDateTime now = ZonedDateTime.now();
        final String file = "someFileName";
        final QueueQueryResponse response = new CurrentSong().response(Arrays.asList(
                "file: " + file,
                "Last-Modified: " + now.format(DateTimeFormatter.ISO_ZONED_DATE_TIME),
                "Id: 10",
                "Time: 99",
                "Pos: 23",
                "OK"
        ), "OK MPD 0.19.0");
        final QueueQueryResponse.QueuedSongMetadata r = response.getSongMetadata().get(0);
        assertThat(r.getTime().orElse(null).intValue()).as("wrong ").isEqualTo(99);
        assertThat(r.getFile().orElse(null)).as("wrong ").isEqualTo(file);
        assertThat(r.getId().orElse(null).intValue()).as("wrong ").isEqualTo(10);
        assertThat(r.getLastModified().orElse(null)).as("wrong ").isEqualTo(now);
        assertThat(r.getPos().orElse(null).intValue()).as("wrong ").isEqualTo(23);
    }

}
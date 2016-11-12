package musicpd.protocol;

import org.junit.Test;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jfraney
 */
public class CurrentSongTest {
    @Test
    public void text() {
        assertThat(new CurrentSong().text()).as("wrong command").isEqualTo("currentsong");
    }

    @Test
    public void response() throws Exception {
        ZonedDateTime now = ZonedDateTime.now();
        String file = "someFileName";
        QueueQueryResponse response = new CurrentSong().response(Arrays.asList(
                "file: " + file,
                "Last-Modified: " + now.format(DateTimeFormatter.ISO_ZONED_DATE_TIME),
                "Id: 10",
                "Time: 99",
                "Pos: 23",
                "OK"
        ));
        QueueQueryResponse.QueuedSongMetadata r = response.getSongMetadata().get(0);
        assertThat(r.getTime().get().intValue()).as("wrong ").isEqualTo(99);
        assertThat(r.getFile().get()).as("wrong ").isEqualTo(file);
        assertThat(r.getId().get().intValue()).as("wrong ").isEqualTo(10);
        assertThat(r.getLastModified().get()).as("wrong ").isEqualTo(now);
        assertThat(r.getPos().get().intValue()).as("wrong ").isEqualTo(23);
    }

}
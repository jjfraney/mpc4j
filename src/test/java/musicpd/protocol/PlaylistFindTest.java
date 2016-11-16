package musicpd.protocol;

import org.jjflyboy.mpc.QueueQueryResponse;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class PlaylistFindTest {
    @Test
    public void text() {
        final String text = new PlaylistFind(Tag.ARTIST, "bob dylan").text();
        assertThat(text).isEqualTo("playlistfind artist \"bob dylan\"");
    }

    @Test
    public void response() {
        final java.util.List<String> lines  = Arrays.asList(
                "file: w2.ogg",
                "Last-Modified: 2016-10-21T21:07:11Z",
                "Genre: Acid Jazz",
                "Album: Mpc Greatest Hits",
                "Track: 2",
                "Title: W2 Song",
                "Date: 1961",
                "Artist: Joe Mpc4J",
                "Time: 11",
                "Pos: 1",
                "Id: 24",
                "OK"
        );
        final QueueQueryResponse r = new PlaylistFind(Tag.ARTIST, "Joe Mpc4J").response(lines, "OK MPD 0.19.0");
        final java.util.List<QueueQueryResponse.QueuedSongMetadata> songInfo = r.getSongMetadata();
        assertThat(songInfo.size()).isEqualTo(1);
        assertThat(songInfo.get(0).getPos().orElse(null)).isEqualTo(1);
        assertThat(songInfo.get(0).getId().orElse(null)).isEqualTo(24);
        assertThat(songInfo.get(0).getTime().orElse(null)).isEqualTo(11);
    }
}



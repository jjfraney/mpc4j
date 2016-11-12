package musicpd.protocol;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class PlaylistFindTest {
    @Test
    public void text() {
        String text = new PlaylistFind(Tag.ARTIST, "bob dylan").text();
        assertThat(text).isEqualTo("playlistfind artist \"bob dylan\"");
    }

    @Test
    public void response() {
        java.util.List<String> lines  = Arrays.asList(
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
        QueueQueryResponse r = new PlaylistFind(Tag.ARTIST, "Joe Mpc4J").response(lines);
        java.util.List<QueueQueryResponse.QueuedSongMetadata> songInfo = r.getSongMetadata();
        assertThat(songInfo.size()).isEqualTo(1);
        assertThat(songInfo.get(0).getPos().get()).isEqualTo(1);
        assertThat(songInfo.get(0).getId().get()).isEqualTo(24);
        assertThat(songInfo.get(0).getTime().get()).isEqualTo(11);
    }
}



package musicpd.protocol;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class LsInfoTest {
    @Test
    public void text() {
        assertThat(new LsInfo().text()).as("wrong command").isEqualTo("lsinfo");
    }

    @Test
    public void response() {
        LsInfo.Response r = new LsInfo().response(Arrays.asList(
                "file: aaa.ogg",
                "Last-Modified: 2016-10-19T00:33:30Z",
                "Time: 100",
                "file: bbb.ogg",
                "Last-Modified: 2016-10-19T00:33:30Z",
                "Time: 200",
                "file: ccc.ogg",
                "Last-Modified: 2016-10-19T00:33:30Z",
                "Time: 300",
                "playlist: t3",
                "Last-Modified: 2016-10-30T02:15:24Z",
                "playlist: test_IT_list",
                "Last-Modified: 2016-11-04T01:29:35Z",
                "playlist: ttt4",
                "Last-Modified: 2016-10-30T02:05:46Z",
                "OK"
        ));
        assertThat(r.isOk()).as("no parse").isTrue();
        List<DatabaseQueryResponse.DatabaseSongMetadata> songs = r.getMetadata();
        assertThat(songs.size()).as("song count").isEqualTo(3);

        assertThat(songs.get(0).getFile().get()).as("song file name").isEqualTo("aaa.ogg");
        assertThat(songs.get(1).getFile().get()).as("song file name").isEqualTo("bbb.ogg");
        assertThat(songs.get(2).getFile().get()).as("song file name").isEqualTo("ccc.ogg");

        List<LsInfo.Response.PlaylistInfo> playlists = r.getPlaylistInfo();
        assertThat(playlists.size()).isEqualTo(3);
        assertThat(playlists.get(0).getPlaylist().get()).isEqualTo("t3");
    }
}
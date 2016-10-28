package org.jjfflyboy.mpc4j;

import org.junit.Test;

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
        DatabaseSongInfoResponse r = new LsInfo().response(new String[] {
                "file: aaa.ogg",
                "Last-Modified: 2016-10-19T00:33:30Z",
                "Time: 100",
                "file: bbb.ogg",
                "Last-Modified: 2016-10-19T00:33:30Z",
                "Time: 200",
                "file: ccc.ogg",
                "Last-Modified: 2016-10-19T00:33:30Z",
                "Time: 300",
                "OK"
        });
        assertThat(r.isOk()).as("no parse").isTrue();
        List<DatabaseSongInfoResponse.DatabaseSongInfo> songs = r.getSongInfo();
        assertThat(songs.size()).as("song count").isEqualTo(3);

        assertThat(songs.get(0).getFile().get()).as("song file name").isEqualTo("aaa.ogg");
        assertThat(songs.get(1).getFile().get()).as("song file name").isEqualTo("bbb.ogg");
        assertThat(songs.get(2).getFile().get()).as("song file name").isEqualTo("ccc.ogg");
    }
}
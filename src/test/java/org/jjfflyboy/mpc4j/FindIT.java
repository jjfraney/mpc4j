package org.jjfflyboy.mpc4j;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests the database search type commands
 * @author jfraney
 */
@RunWith(Arquillian.class)
public class FindIT {
    private MPC mpc;
    @Before
    public void before() {
        mpc = new MPC();
    }

    @Test
    @RunAsClient
    public void test() throws IOException {
        DatabaseSongInfoResponse r = mpc.send(new Find(Tag.TITLE, "W2 Song"));

        assertThat(r.isOk()).isTrue();

        assertThat(r.getSongInfo().size()).isEqualTo(1);

        List<DatabaseSongInfoResponse.DatabaseSongInfo> songs = r.getSongInfo();
        DatabaseSongInfoResponse.DatabaseSongInfo songInfo = songs.stream().filter(s -> s.getFile().get().equals("w2.ogg")).findAny().get();
        assertThat(songInfo.getLastModified().get()).isEqualTo("2016-10-21T21:09:49Z");
        assertThat(songInfo.getTag(Tag.ARTIST).get()).isEqualTo("Joe Mpc4J");

    }
    @Test
    @RunAsClient
    public void testWithAny() throws IOException {
        DatabaseSongInfoResponse r = mpc.send(new Find(Find.Special.ANY, "W2 Song"));

        assertThat(r.isOk()).isTrue();

        assertThat(r.getSongInfo().size()).isEqualTo(1);

        List<DatabaseSongInfoResponse.DatabaseSongInfo> songs = r.getSongInfo();
        DatabaseSongInfoResponse.DatabaseSongInfo songInfo = songs.stream().filter(s -> s.getFile().get().equals("w2.ogg")).findAny().get();
        assertThat(songInfo.getLastModified().get()).isEqualTo("2016-10-21T21:09:49Z");
        assertThat(songInfo.getTag(Tag.ARTIST).get()).isEqualTo("Joe Mpc4J");

    }

}

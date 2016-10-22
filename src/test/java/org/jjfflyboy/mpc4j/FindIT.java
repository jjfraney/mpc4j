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
        SongSearchResponse r = mpc.send(new Find(Tag.TITLE, "W2 Song"));

        assertThat(r.isOk()).isTrue();

        assertThat(r.getSongs().size()).isEqualTo(1);

        List<SongSearchResponse.Song> songs = r.getSongs();
        SongSearchResponse.Song song = songs.stream().filter(s -> s.getFile().get().equals("w2.ogg")).findAny().get();
        assertThat(song.getLastModified().get()).isEqualTo("2016-10-21T21:07:11Z");
        assertThat(song.getTag(Tag.ARTIST).get()).isEqualTo("Joe Mpc4J");

    }
    @Test
    @RunAsClient
    public void testWithAny() throws IOException {
        SongSearchResponse r = mpc.send(new Find(Find.Special.ANY, "W2 Song"));

        assertThat(r.isOk()).isTrue();

        assertThat(r.getSongs().size()).isEqualTo(1);

        List<SongSearchResponse.Song> songs = r.getSongs();
        SongSearchResponse.Song song = songs.stream().filter(s -> s.getFile().get().equals("w2.ogg")).findAny().get();
        assertThat(song.getLastModified().get()).isEqualTo("2016-10-21T21:07:11Z");
        assertThat(song.getTag(Tag.ARTIST).get()).isEqualTo("Joe Mpc4J");

    }

}

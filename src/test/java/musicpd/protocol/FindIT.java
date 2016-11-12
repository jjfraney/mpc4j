package musicpd.protocol;

import org.jjflyboy.mpc.MPC;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests the database search type commands
 * <p>
 *     Requires an mpd server, running on localhsot:6600.  See mpc4j/docker/mpd.
 * </p>
 * @author jfraney
 */
public class FindIT {
    private MPC mpc;
    @Before
    public void before() {
        mpc = new MPC();
    }

    @Test
    public void test() throws IOException {
        DatabaseQueryResponse r = mpc.send(new Find(Tag.TITLE, "W2 Song"));

        assertThat(r.isOk()).isTrue();

        assertThat(r.getMetadata().size()).isEqualTo(1);

        List<DatabaseQueryResponse.DatabaseSongMetadata> songs = r.getMetadata();
        DatabaseQueryResponse.DatabaseSongMetadata songInfo = songs.stream().filter(s -> s.getFile().get().equals("w2.ogg")).findAny().get();
        assertThat(songInfo.getLastModified().get()).isEqualTo("2016-10-21T21:09:49Z");
        assertThat(songInfo.getTag(Tag.ARTIST).get()).isEqualTo("Joe Mpc4J");

    }
    @Test
    public void testWithAny() throws IOException {
        DatabaseQueryResponse r = mpc.send(new Find(Find.Special.ANY, "W2 Song"));

        assertThat(r.isOk()).isTrue();

        assertThat(r.getMetadata().size()).isEqualTo(1);

        List<DatabaseQueryResponse.DatabaseSongMetadata> songs = r.getMetadata();
        DatabaseQueryResponse.DatabaseSongMetadata songInfo = songs.stream().filter(s -> s.getFile().get().equals("w2.ogg")).findAny().get();
        assertThat(songInfo.getLastModified().get()).isEqualTo("2016-10-21T21:09:49Z");
        assertThat(songInfo.getTag(Tag.ARTIST).get()).isEqualTo("Joe Mpc4J");

    }

}

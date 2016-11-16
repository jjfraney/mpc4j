package musicpd.protocol;

import org.jjflyboy.mpc.DatabaseQueryResponse;
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
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class FindIT {
    private MPC mpc;
    @Before
    public void before() {
        mpc = new MPC();
    }

    @Test
    public void test() throws IOException {
        final DatabaseQueryResponse r = mpc.send(new Find(Tag.TITLE, "W2 Song"));

        assertThat(r.isOk()).isTrue();

        assertThat(r.getMetadata().size()).isEqualTo(1);

        final List<DatabaseQueryResponse.DatabaseSongMetadata> songs = r.getMetadata();
        final DatabaseQueryResponse.DatabaseSongMetadata songInfo = songs.stream().filter(s -> s.getFile().orElse(null).equals("w2.ogg")).findAny().orElse(null);
        assertThat(songInfo.getTag(Tag.ARTIST).orElse(null)).isEqualTo("Joe Mpc4J");

    }
    @Test
    public void testWithAny() throws IOException {
        final DatabaseQueryResponse r = mpc.send(new Find(Find.Special.ANY, "W2 Song"));

        assertThat(r.isOk()).isTrue();

        assertThat(r.getMetadata().size()).isEqualTo(1);

        final List<DatabaseQueryResponse.DatabaseSongMetadata> songs = r.getMetadata();
        final DatabaseQueryResponse.DatabaseSongMetadata songInfo = songs.stream().filter(s -> s.getFile().orElse(null).equals("w2.ogg")).findAny().orElse(null);
        assertThat(songInfo.getTag(Tag.ARTIST).orElse(null)).isEqualTo("Joe Mpc4J");

    }

}

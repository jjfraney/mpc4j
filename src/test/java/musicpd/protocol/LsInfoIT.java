package musicpd.protocol;

import com.github.jjfraney.mpc.DatabaseQueryResponse;
import com.github.jjfraney.mpc.MPC;
import com.github.jjfraney.mpc.SongMetadata;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <p>
 *     Requires an mpd server, running on localhsot:6600.  See mpc4j/docker/mpd.
 * </p>
 * Tests the playback control type commands
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class LsInfoIT {
    private MPC mpc;
    @Before
    public void before() {
        mpc = new MPC();
    }

    @Test
    public void test() throws IOException {
        final LsInfo.Response r = mpc.send(new LsInfo());

        assertThat(r.isOk()).isTrue();

        assertThat(r.getMetadata().size()).isEqualTo(3);

        final List<DatabaseQueryResponse.DatabaseSongMetadata> songs = r.getMetadata();
        final SongMetadata songInfo = songs.stream().filter(s -> s.getFile().orElse(null).equals("w1.ogg")).findAny().orElse(null);
        assertThat(songInfo.getTag(Tag.ARTIST).orElse(null)).isEqualTo("Joe Mpc4J");

    }

}

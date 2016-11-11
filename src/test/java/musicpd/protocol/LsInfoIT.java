package musicpd.protocol;

import org.jjflyboy.mpc.MPC;
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
 * @author jfraney
 */
public class LsInfoIT {
    private MPC mpc;
    @Before
    public void before() {
        mpc = new MPC();
    }

    @Test
    public void test() throws IOException {
        LsInfo.Response r = mpc.send(new LsInfo());

        assertThat(r.isOk()).isTrue();

        assertThat(r.getSongInfo().size()).isEqualTo(3);

        List<DatabaseSongInfoResponse.DatabaseSongInfo> songs = r.getSongInfo();
        SongInfoResponse.SongInfo songInfo = songs.stream().filter(s -> s.getFile().get().equals("w1.ogg")).findAny().get();
        assertThat(songInfo.getLastModified().get()).isEqualTo("2016-10-21T21:10:14Z");
        assertThat(songInfo.getTag(Tag.ARTIST).get()).isEqualTo("Joe Mpc4J");

    }

}

package musicpd.protocol;

import com.github.jjfraney.mpc.Command;
import com.github.jjfraney.mpc.DatabaseQueryResponse;
import com.github.jjfraney.mpc.MPC;
import com.github.jjfraney.mpc.MpcRuntimeException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <p>
 *     Requires an mpd server, running on localhsot:6600.  See mpc4j/docker/mpd.
 * </p>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class ListPlaylistIT {
    private MPC mpc;

    private final String TEST_PLAYLIST = "test_IT_list";
    private Rm remove = new Rm(TEST_PLAYLIST);

    @Before
    public void before() throws IOException {
        mpc = new MPC();
        final Command.Response r = mpc.send(remove);
        if(! r.isOk() && r.getAck().orElse(null).getError() != 50) {
            throw new MpcRuntimeException("fail to remove: " + r.getAck().orElse(null).getMessageText());
        }
    }

    @Test
    public void add() throws IOException {
        final Command.Response r = mpc.send(new PlaylistAdd(TEST_PLAYLIST, "w1.ogg"));
        assertThat(r.isOk()).isTrue();

        final ListPlaylist.Response lpl = mpc.send(new ListPlaylist(TEST_PLAYLIST));
        assertThat(lpl.getFiles().size()).isEqualTo(1);
        assertThat(lpl.getFiles().get(0)).isEqualTo("w1.ogg");

        final ListPlaylists.Response rpl = mpc.send(new ListPlaylists());
        assertThat(rpl.isOk()).isTrue();

    }
    @Test
    public void delete() throws IOException {
        final Command.Response radd = mpc.send(new PlaylistAdd(TEST_PLAYLIST, "w1.ogg"));
        assertThat(radd.isOk()).isTrue();

        final Command.Response rdelete = mpc.send(new PlaylistDelete(TEST_PLAYLIST, 0));
        assertThat(rdelete.isOk()).isTrue();

        final ListPlaylist.Response lpl = mpc.send(new ListPlaylist(TEST_PLAYLIST));
        assertThat(lpl.getFiles().size()).isEqualTo(0);
    }
    @Test
    public void load() throws IOException {
        final Command.Response rclear = mpc.send(new Clear());
        assertThat(rclear.isOk()).isTrue();

        final Command.Response radd = mpc.send(new PlaylistAdd(TEST_PLAYLIST, "w1.ogg"));
        assertThat(radd.isOk()).isTrue();

        final Command.Response rload = mpc.send(new Load(TEST_PLAYLIST));
        assertThat(rload.isOk()).isTrue();

        final DatabaseQueryResponse rfind = mpc.send(new Find(Find.Special.FILE, "w1.ogg"));
        assertThat(rfind.isOk()).isTrue();
        final java.util.List<DatabaseQueryResponse.DatabaseSongMetadata> songInfo = rfind.getMetadata();
        assertThat(songInfo.size()).isEqualTo(1);
        assertThat(songInfo.get(0).getFile().orElse(null)).isEqualTo("w1.ogg");


    }

}

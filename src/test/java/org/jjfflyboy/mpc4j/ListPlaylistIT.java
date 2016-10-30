package org.jjfflyboy.mpc4j;

import org.junit.Before;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class ListPlaylistIT {
    private MPC mpc;

    private final String TEST_PLAYLIST = "test_IT_list";
    private Rm remove = new Rm(TEST_PLAYLIST);

    @Before
    public void before() throws IOException {
        mpc = new MPC();
        Command.Response r = mpc.send(remove);
        if(! r.isOk()) {
            if(r.getAck().get().getError() != 50) {
                throw new RuntimeException("fail to remove: " + r.getAck().get().getMessageText());
            }
        }
    }

    @Test
    public void add() throws IOException {
        Command.Response r = mpc.send(new PlaylistAdd(TEST_PLAYLIST, "w1.ogg"));
        assertThat(r.isOk()).isTrue();

        ListPlaylist.Response lpl = mpc.send(new ListPlaylist(TEST_PLAYLIST));
        assertThat(lpl.getFiles().size()).isEqualTo(1);
        assertThat(lpl.getFiles().get(0)).isEqualTo("w1.ogg");

        ListPlaylists.Response rpl = mpc.send(new ListPlaylists());
        assertThat(rpl.isOk()).isTrue();
        java.util.List<ListPlaylists.Response.Playlist> playlists = rpl.getPlaylists();

    }
    @Test
    public void delete() throws IOException {
        Command.Response radd = mpc.send(new PlaylistAdd(TEST_PLAYLIST, "w1.ogg"));
        assertThat(radd.isOk()).isTrue();

        Command.Response rdelete = mpc.send(new PlaylistDelete(TEST_PLAYLIST, 0));
        assertThat(rdelete.isOk()).isTrue();

        ListPlaylist.Response lpl = mpc.send(new ListPlaylist(TEST_PLAYLIST));
        assertThat(lpl.getFiles().size()).isEqualTo(0);
    }
    @Test
    public void load() throws IOException {
        Command.Response rclear = mpc.send(new Clear());
        assertThat(rclear.isOk()).isTrue();

        Command.Response radd = mpc.send(new PlaylistAdd(TEST_PLAYLIST, "w1.ogg"));
        assertThat(radd.isOk()).isTrue();

        Command.Response rload = mpc.send(new Load(TEST_PLAYLIST));
        assertThat(rload.isOk()).isTrue();

        DatabaseSongInfoResponse rfind = mpc.send(new Find(Find.Special.FILE, "w1.ogg"));
        assertThat(rfind.isOk()).isTrue();
        java.util.List<DatabaseSongInfoResponse.DatabaseSongInfo> songInfo = rfind.getSongInfo();
        assertThat(songInfo.size()).isEqualTo(1);
        assertThat(songInfo.get(0).getFile().get()).isEqualTo("w1.ogg");


    }

}

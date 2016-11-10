package org.jjflyboy.mpc4j;

/**
 * playlistdelete command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>MPD Document: Stored playlists.</a>
 * @author jfraney
 */
public class PlaylistDelete extends Simple {
    /**
     * @param name of playlist
     * @param songPos of song to delete
     */
    public PlaylistDelete(String name, Integer songPos) {
        super(adapt(name), adapt(songPos));
    }
}

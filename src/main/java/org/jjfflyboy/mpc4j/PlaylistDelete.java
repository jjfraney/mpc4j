package org.jjfflyboy.mpc4j;

/**
 * playlistdelete command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>MPD Document: Control playback.</a>
 * @author jfraney
 */
public class PlaylistDelete extends Simple {
    public PlaylistDelete(String name, Integer songPos) {
        super(adapt(name), adapt(songPos));
    }
}

package org.jjfflyboy.mpc4j;

/**
 * playlistclear command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>MPD Document: Control playback.</a>
 * @author jfraney
 */
public class PlaylistClear extends Simple {
    /**
     * @param name of playlist
     */
    public PlaylistClear(String name) {
        super(adapt(name));
    }
}

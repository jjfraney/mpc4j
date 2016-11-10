package org.jjflyboy.mpc4j;

/**
 * playlistmove command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>MPD Document: Stored playlists.</a>
 * @author jfraney
 */
public class PlaylistMove extends Simple {
    /**
     * @param name of playlist
     * @param from current position
     * @param to new position
     */
    public PlaylistMove(String name, Integer from, Integer to) {
        super(adapt(name), new RangeParameter(from, to));
    }
}

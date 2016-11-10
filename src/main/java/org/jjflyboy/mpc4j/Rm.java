package org.jjflyboy.mpc4j;

/**
 * rm command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>MPD Document: Stored playlists.</a>
 * @author jfraney
 */
public class Rm extends Simple {
    /**
     * @param name of playlist
     */
    public Rm(String name) {
        super(adapt(name));
    }
}

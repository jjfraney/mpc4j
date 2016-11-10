package org.jjflyboy.mpc4j;

/**
 * save command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>MPD Document: Stored playlists.</a>
 * @author jfraney
 */
public class Save extends Simple {
    /**
     * @param name of playlist
     */
    public Save(String name) {
        super(adapt(name));
    }
}

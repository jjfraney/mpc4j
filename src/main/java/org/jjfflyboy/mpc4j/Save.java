package org.jjfflyboy.mpc4j;

/**
 * save command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>MPD Document: Control playback.</a>
 * @author jfraney
 */
public class Save extends Simple {
    public Save(String name) {
        super(adapt(name));
    }
}

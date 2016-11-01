package org.jjfflyboy.mpc4j;

/**
 * rm command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>MPD Document: Control playback.</a>
 * @author jfraney
 */
public class Rm extends Simple {
    public Rm(String name) {
        super(adapt(name));
    }
}

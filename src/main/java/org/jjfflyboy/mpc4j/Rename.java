package org.jjfflyboy.mpc4j;

/**
 * rename command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>MPD Document: Control playback.</a>
 * @author jfraney
 */
public class Rename extends Simple {
    public Rename(String name, String newName) {
        super(adapt(name), adapt(newName));
    }
}

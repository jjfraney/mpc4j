package org.jjfflyboy.mpc4j;

/**
 * playlistadd command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>MPD Document: Control playback.</a>
 * @author jfraney
 */
public class PlaylistAdd extends Simple {
    public PlaylistAdd(String name, String uri) {
        super(adapt(name), adapt(uri));
    }
}

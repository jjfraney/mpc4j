package org.jjfflyboy.mpc4j;

/**
 * load command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>MPD Document: Control playback.</a>
 * @author jfraney
 */
public class Load extends Simple {
    /**
     * @param name of playlist
     */
    public Load(String name) {
        super(adapt(name));
    }

    /**
     * @param name of playlist
     * @param start position of first song in range to load
     * @param end position of last song in range to load
     */
    public Load(String name, Integer start, Integer end) {
        super(adapt(name), new RangeParameter(start, end));
    }
}

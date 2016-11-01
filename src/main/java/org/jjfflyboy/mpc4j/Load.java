package org.jjfflyboy.mpc4j;

/**
 * load command from
 * <a href='https://www.musicpd.org/doc/protocol/playlist_files.html'>MPD Document: Control playback.</a>
 * @author jfraney
 */
public class Load extends Simple {
    public Load(String name) {
        super(adapt(name));
    }
    public Load(String name, Integer start, Integer end) {
        super(adapt(name), new RangeParameter(start, end));
    }
}

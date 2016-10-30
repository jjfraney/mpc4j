package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class PlaylistAdd extends Simple {
    public PlaylistAdd(String name, String uri) {
        super(adapt(name), adapt(uri));
    }
}

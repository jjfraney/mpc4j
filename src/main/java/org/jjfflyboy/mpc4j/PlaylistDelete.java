package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class PlaylistDelete extends Simple {
    public PlaylistDelete(String name, Integer songPos) {
        super(adapt(name), adapt(songPos));
    }
}

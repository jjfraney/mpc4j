package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class PlaylistMove extends Simple {
    public PlaylistMove(String name, Integer from, Integer to) {
        super(adapt(name), new RangeParameter(from, to));
    }
}

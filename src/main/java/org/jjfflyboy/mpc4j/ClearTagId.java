package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class ClearTagId extends Simple {
    public ClearTagId(Integer songId, Tag tag) {
        super(adapt(songId), tag);
    }
}

package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class AddTagId extends Simple {
    public AddTagId(Integer songId, Tag tag, String value) {
        super(adapt(songId), tag, adapt(value));
    }
}

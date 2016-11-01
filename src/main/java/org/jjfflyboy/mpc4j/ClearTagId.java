package org.jjfflyboy.mpc4j;

/**
 * cleartagid command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * @author jfraney
 */
public class ClearTagId extends Simple {
    public ClearTagId(Integer songId, Tag tag) {
        super(adapt(songId), tag);
    }
}

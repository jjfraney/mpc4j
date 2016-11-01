package org.jjfflyboy.mpc4j;

/**
 * addtagid command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * @author jfraney
 */
public class AddTagId extends Simple {
    public AddTagId(Integer songId, Tag tag, String value) {
        super(adapt(songId), tag, adapt(value));
    }
}

package org.jjfflyboy.mpc4j;

import java.util.Optional;

/**
 * deleteid command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * @author jfraney
 */
public class DeleteId extends Simple {
    public DeleteId(Integer songId) {
        super(adapt(songId));
    }
}

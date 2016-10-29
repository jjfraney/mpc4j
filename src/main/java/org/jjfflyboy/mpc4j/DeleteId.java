package org.jjfflyboy.mpc4j;

import java.util.Optional;

/**
 * @author jfraney
 */
public class DeleteId extends Simple {
    public DeleteId(Integer songId) {
        super(adapt(songId));
    }
}

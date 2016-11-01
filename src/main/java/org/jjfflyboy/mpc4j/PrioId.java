package org.jjfflyboy.mpc4j;

import java.util.Arrays;

/**
 * prioid command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * @author jfraney
 */
public class PrioId extends Simple {

    public PrioId(Integer priority, Integer id, Integer ... ids) {
        super(adapt(priority), adapt(id), adapt(ids));
    }
}

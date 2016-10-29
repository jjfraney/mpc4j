package org.jjfflyboy.mpc4j;

import java.util.Arrays;

/**
 * @author jfraney
 */
public class PrioId extends Simple {

    public PrioId(Integer priority, Integer id, Integer ... ids) {
        super(adapt(priority), adapt(id), adapt(ids));
    }
}

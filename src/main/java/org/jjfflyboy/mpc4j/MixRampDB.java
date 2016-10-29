package org.jjfflyboy.mpc4j;

import java.math.BigDecimal;

/**
 * @author jfraney
 */
public class MixRampDB extends Simple {
    public MixRampDB(BigDecimal mixRampDB) {
        super(adapt(mixRampDB));
    }
}

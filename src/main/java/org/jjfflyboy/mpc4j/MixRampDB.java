package org.jjfflyboy.mpc4j;

import java.math.BigDecimal;

/**
 * @author jfraney
 */
public class MixRampDB extends Simple {
    private BigDecimal mixRampDB;

    public MixRampDB(BigDecimal mixRampDB) {
        this.mixRampDB = mixRampDB;
    }

    @Override
    public String text() {
        return "mixrampdb " + mixRampDB.toString();
    }
}

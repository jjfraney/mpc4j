package org.jjfflyboy.mpc4j;

import java.math.BigDecimal;

/**
 * @author jfraney
 */
public class MixRampDB implements Command<MixRampDB.Response> {
    private BigDecimal mixRampDB;

    public MixRampDB(BigDecimal mixRampDB) {
        this.mixRampDB = mixRampDB;
    }

    @Override
    public String text() {
        return "mixrampdb " + mixRampDB.toString();
    }

    @Override
    public Response response(String[] responseLines) {
        return new Response(responseLines);
    }

    public static class Response extends AbstractCommandResponse {
        Response(String[] responseLines) {
            super(responseLines);
        }
    }
}

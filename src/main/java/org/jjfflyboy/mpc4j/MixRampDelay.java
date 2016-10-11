package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class MixRampDelay implements Command<MixRampDelay.Response> {
    final private Integer mixRampDelay;

    /**
     * A value or 'nan'.  Note: per protocol,'nan' disables MixRamp overlapping.
     * @param mixRampDelay value or null (for 'nan').
     */
    public MixRampDelay(Integer mixRampDelay) {
        this.mixRampDelay = mixRampDelay;
    }

    /**
     * send value of 'nan'.
     */
    public MixRampDelay() {
        this.mixRampDelay = null;
    }

    @Override
    public String text() {
        return "mixrampdelay " + ((mixRampDelay == null) ? "nan" : mixRampDelay.toString());
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

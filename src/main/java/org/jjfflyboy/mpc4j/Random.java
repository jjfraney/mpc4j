package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class Random implements Command<Random.Response> {
    final private Toggle toggle;

    public Random(Toggle toggle) {
        this.toggle = toggle;
    }

    @Override
    public String text() {
        return "random " + toggle.encode();
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

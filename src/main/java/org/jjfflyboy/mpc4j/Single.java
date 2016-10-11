package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class Single implements Command<Single.Response> {
    final private Toggle toggle;

    public Single(Toggle toggle) {
        this.toggle = toggle;
    }

    @Override
    public String text() {
        return "single " + toggle.encode();
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

package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class Repeat implements Command<Repeat.Response> {
    final private Toggle toggle;

    public Repeat(Toggle toggle) {
        this.toggle = toggle;
    }

    @Override
    public String text() {
        return "repeat " + toggle.encode();
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

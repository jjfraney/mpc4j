package org.jjfflyboy.mpc4j;

/**
 * @Author jfraney
 */
public class Crossfade implements Command<Crossfade.Response> {
    final private Integer crossfade;
    public Crossfade(Integer crossfade) {
        this.crossfade = crossfade;
    }
    public Crossfade() {
        this.crossfade = 0;
    }
    @Override
    public String text() {
        return "crossfade " + crossfade.toString();
    }

    @Override
    public Crossfade.Response response(String[] responseLines) {
        return new Response(responseLines);
    }

    public static class Response extends AbstractCommandResponse {
        Response(String[] responseLines) {
            super(responseLines);
        }
    }

}

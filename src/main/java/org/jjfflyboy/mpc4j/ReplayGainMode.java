package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class ReplayGainMode implements Command<ReplayGainMode.Response> {
    // I don't like the name "ReplayGainMode.Mode"....just following the protocol here.
    public enum Mode {
        OFF, TRACK, ALBUM, AUTO;
        public static Mode decode(String value) {
            return valueOf(value.toUpperCase());
        }
        public String encode() {
            return name().toLowerCase();
        }
    }
    final private Mode mode;

    public ReplayGainMode(Mode mode) {
        this.mode = mode;
    }

    @Override
    public String text() {
        return "replay_gain_mode " + mode.encode();
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

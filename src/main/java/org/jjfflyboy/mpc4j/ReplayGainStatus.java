package org.jjfflyboy.mpc4j;

import java.util.Optional;

/**
 * @Author jfraney
 */
public class ReplayGainStatus implements Command<ReplayGainStatus.Response> {
    @Override
    public String text() {
        return "replay_gain_status";
    }

    @Override
    public ReplayGainStatus.Response response(String[] responseLines) {
        return new Response(responseLines);
    }

    public static class Response extends Simple.Response {
        Response(String[] responseLines) {
            super(responseLines);
        }

        public Optional<ReplayGainMode.Mode> getReplayGainMode() {
            return getModeValue("replay_gain_mode");
        }
        protected Optional<ReplayGainMode.Mode> getModeValue(String fieldName) {
            return findFieldValue(fieldName).map(s -> ReplayGainMode.Mode.decode(s));
        }
    }
}

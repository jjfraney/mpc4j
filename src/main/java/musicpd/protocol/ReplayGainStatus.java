package musicpd.protocol;

import java.util.Optional;

/**
 * replay_gain_status command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_option_commands.html'>MPD Playback option commands.</a>
 * <p>
 *     This command returns the current replay gain mode in its response.
 * </p>
 * @Author jfraney
 */
public class ReplayGainStatus extends AbstractCommand<ReplayGainStatus.Response> {
    public ReplayGainStatus() {
        super();
    }

    @Override
    protected String command() {
        return "replay_gain_status";
    }
    @Override
    public ReplayGainStatus.Response response(java.util.List<String> responseLines) {
        return new Response(responseLines);
    }

    /**
     * access to data in response to replay_gain_status
     */
    public static class Response extends HealthResponse {
        Response(java.util.List<String> responseLines) {
            super(responseLines);
        }

        /**
         * @return value of 'replay_gain_mode: ' line
         */
        public Optional<ReplayGainMode.Mode> getReplayGainMode() {
            return findFieldValue("replay_gain_mode").map(s -> ReplayGainMode.Mode.decode(s));
        }
    }
}

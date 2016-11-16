package musicpd.protocol;

import com.github.jjfraney.mpc.AbstractCommand;
import com.github.jjfraney.mpc.HealthResponse;

import java.util.Optional;

/**
 * replay_gain_status command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_option_commands.html'>
 *     MPD Playback option commands.</a>
 * <p>
 *     This command returns the current replay gain mode in its response.
 * </p>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class ReplayGainStatus extends AbstractCommand<ReplayGainStatus.Response> {

    @Override
    protected String command() {
        return "replay_gain_status";
    }
    @Override
    public ReplayGainStatus.Response response(final java.util.List<String> responseLines, final String connectResponse) {
        return new Response(responseLines, connectResponse);
    }

    /**
     * access to data in response to replay_gain_status
     */
    public static class Response extends HealthResponse {
        Response(final java.util.List<String> responseLines, final String connectResponse) {
            super(responseLines, connectResponse);
        }

        /**
         * @return value of 'replay_gain_mode: ' line
         */
        public Optional<ReplayGainMode.Mode> getReplayGainMode() {
            return findFieldValue("replay_gain_mode").map(ReplayGainMode.Mode::decode);
        }
    }
}

package musicpd.protocol;

import org.jjflyboy.mpc.MPC;
import org.jjflyboy.mpc.SimpleResponse;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <p>
 *     Requires an mpd server, running on localhsot:6600.  See mpc4j/docker/mpd.
 * </p>
 ** Tests the playback control type commands
 * @author jfraney
 */
public class PlaybackControlIT {
    private MPC mpc;
    @Before
    public void before() {
        mpc = new MPC();
    }

    @Test
    public void testPlay() throws IOException {
        final Play playCommand = new Play();
        final Stop stopCommand = new Stop();

        final SimpleResponse playResponse = mpc.send(playCommand);
        final SimpleResponse stopResponse = mpc.send(stopCommand);

        assertThat(playResponse.isOk()).as("play starts").isTrue();
        assertThat(stopResponse.isOk()).as("play stopped").isTrue();

        final Status.Response statusResponse = mpc.send(new Status());
        assertThat(statusResponse.getState().orElse(null)).as("is not playing").isEqualTo("stop");
    }

}

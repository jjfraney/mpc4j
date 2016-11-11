package musicpd.protocol;

import org.jjflyboy.mpc.MPC;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <p>
 *     Requires an mpd server, running on localhsot:6600.  See mpc4j/docker/mpd.
 * </p>
 * @author jfraney
 */
public class CloseIT {

    private MPC mpc;
    @Before
    public void before() throws IOException {
        mpc = new MPC();
    }

    @Test
    public void close() throws IOException {
        SimpleResponse r = mpc.send(new Close());
        assertThat(r.isOk()).isFalse();
        assertThat(r.getAck()).isNotPresent();
        assertThat(r.getResponseLines().size()).isEqualTo(0);
    }
}

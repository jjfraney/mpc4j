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
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class ClearIT {

    private MPC mpc;
    @Before
    public void before() throws IOException {
        mpc = new MPC();
    }

    @Test
    public void clear() throws IOException {
        final SimpleResponse r = mpc.send(new Clear());
        assertThat(r.isOk()).isTrue();
    }
}

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
 ** @author jfraney
 */
public class OutputsIT {

    private MPC mpc;
    @Before
    public void before() {
        mpc = new MPC();
    }

    @Test
    public void outputs() throws IOException {
        Outputs.Response r = mpc.send(new Outputs());
        java.util.List<Outputs.Response.Output> outputs = r.getOutputs();
        assertThat(outputs.size()).isGreaterThanOrEqualTo(1);
        assertThat(outputs.get(0).getOutputEnabled()).isPresent();
        assertThat(outputs.get(0).getOutputId()).isPresent();
        assertThat(outputs.get(0).getOutputName()).isPresent();
    }
}

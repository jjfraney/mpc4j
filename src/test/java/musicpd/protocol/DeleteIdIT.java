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
 * @author jfraney
 */
public class DeleteIdIT {

    private MPC mpc;
    @Before
    public void before() {
        mpc = new MPC();
    }

    @Test
    public void delete() throws IOException {
        final AddId.Response addResponse = mpc.send(new AddId("w1.ogg"));
        final Integer id = addResponse.getId().orElse(null);
        final SimpleResponse deleteResponse = mpc.send(new DeleteId(id));
        assertThat(deleteResponse.isOk()).isTrue();
    }
}

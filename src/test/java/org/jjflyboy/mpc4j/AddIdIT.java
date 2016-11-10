package org.jjflyboy.mpc4j;

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
public class AddIdIT {

    private MPC mpc;
    @Before
    public void before() {
        mpc = new MPC();
    }

    @Test
    public void addW1NoPos() throws IOException {
        AddId.Response r = mpc.send(new AddId("w1.ogg", 0));
        assertThat(r.isOk()).isTrue();
        assertThat(r.getId()).isPresent();
    }
}

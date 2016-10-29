package org.jjfflyboy.mpc4j;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class ClearIT {

    private MPC mpc;
    @Before
    public void before() throws IOException {
        mpc = new MPC();
    }

    @Test
    public void clear() throws IOException {
        SimpleResponse r = mpc.send(new Clear());
        assertThat(r.isOk()).isTrue();
    }
}

package org.jjfflyboy.mpc4j;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
@RunWith(Arquillian.class)
@RunAsClient
public class StatusQueryIT {

    private MPC mpc;
    @Before
    public void before() {
        mpc = new MPC();
    }
    @Test
    public void testStatus() throws IOException {
        Status command = new Status();
        Status.Response r = mpc.send(command);
        assertThat(r.isOk()).as("command status").isTrue();
        assertThat(r.getRandom()).as("response value").isPresent();
        assertThat(r.getXfade()).as("response value").isNotPresent();
    }

    @Test
    public void testStats() throws IOException {
        Stats command = new Stats();
        Stats.Response r = mpc.send(command);
        assertThat(r.isOk()).as("command status").isTrue();
    }
}

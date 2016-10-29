package org.jjfflyboy.mpc4j;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests the playback control type commands
 * @author jfraney
 */
@RunWith(Arquillian.class)
public class PlaybackControlIT {
    private MPC mpc;
    @Before
    public void before() {
        mpc = new MPC();
    }

    private static int count =0;
    @Test
    @RunAsClient
    public void testPlay() throws IOException {
        Play playCommand = new Play();
        Stop stopCommand = new Stop();

        SimpleResponse playResponse = mpc.send(playCommand);
        SimpleResponse stopResponse = mpc.send(stopCommand);

        assertThat(playResponse.isOk()).as("play starts").isTrue();
        assertThat(stopResponse.isOk()).as("play stopped").isTrue();

        Status.Response statusResponse = mpc.send(new Status());
        assertThat(statusResponse.getState().get()).as("is not playing").isEqualTo("stop");
    }

}

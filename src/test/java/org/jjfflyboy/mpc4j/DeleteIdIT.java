package org.jjfflyboy.mpc4j;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
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
        AddId.Response addResponse = mpc.send(new AddId("w1.ogg"));
        Integer id = addResponse.getId().get();
        SimpleResponse deleteResponse = mpc.send(new DeleteId(id));
        assertThat(deleteResponse.isOk()).isTrue();
    }
}

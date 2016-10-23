package org.jjfflyboy.mpc4j;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class CountIT {

    MPC mpc;
    @Before
    public void before() {
        mpc = new MPC();
    }
    @Test
    public void textCountWithGroup() throws IOException {
        Map<Count.Type, String> q = new HashMap<>();
        q.put(Tag.ARTIST, "Joe Mpc4J");
        Count cmd = new Count(q, Tag.TITLE);

        Count.Response r = mpc.send(cmd);
        assertThat(r.isOk()).isTrue();

        // group is specified
        assertThat(r.getSongs()).isNotPresent();
        assertThat(r.getPlaytime()).isNotPresent();

        List<Count.Response.Group> groups = r.getGroups();
        assertThat(groups.size()).isEqualTo(3);

        Count.Response.Group first = r.getGroups().get(0);
        assertThat(first.getTag(Tag.TITLE)).isPresent();
        assertThat(first.getTag(Tag.TITLE).get()).isEqualTo("W1 Song");
    }

    @Test
    public void textNoGroup() throws IOException {
        Count cmd = new Count(Tag.ARTIST, "Joe Mpc4J");
        Count.Response r = mpc.send(cmd);
        assertThat(r.isOk()).isTrue();
        assertThat(r.getSongs().get()).isEqualTo(3);

        // group is not specified.
        assertThat(r.getGroups().size()).isEqualTo(0);
        assertThat(r.getSongs()).isPresent();
        assertThat(r.getPlaytime()).isPresent();

    }
}

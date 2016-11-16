package musicpd.protocol;

import org.jjflyboy.mpc.MPC;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <p>
 *     Requires an mpd server, running on localhsot:6600.  See mpc4j/docker/mpd.
 * </p>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class CountIT {

    MPC mpc;
    @Before
    public void before() {
        mpc = new MPC();
    }
    @Test
    public void textCountWithGroup() throws IOException {
        final Count cmd = new Count(Tag.ARTIST, "Joe Mpc4J", Tag.TITLE);

        final Count.Response r = mpc.send(cmd);
        assertThat(r.isOk()).isTrue();

        // group is specified
        assertThat(r.getSongs()).isNotPresent();
        assertThat(r.getPlaytime()).isNotPresent();

        final List<Count.Response.Group> groups = r.getGroups();
        assertThat(groups.size()).isEqualTo(3);

        final Count.Response.Group first = r.getGroups().get(0);
        assertThat(first.getTag(Tag.TITLE)).isPresent();
        assertThat(first.getTag(Tag.TITLE).orElse(null)).isEqualTo("W1 Song");
    }

    @Test
    public void textNoGroup() throws IOException {
        final Count cmd = new Count(Tag.ARTIST, "Joe Mpc4J");
        final Count.Response r = mpc.send(cmd);
        assertThat(r.isOk()).isTrue();
        assertThat(r.getSongs().orElse(null)).isEqualTo(3);

        // group is not specified.
        assertThat(r.getGroups().size()).isEqualTo(0);
        assertThat(r.getSongs()).isPresent();
        assertThat(r.getPlaytime()).isPresent();

    }
}

package musicpd.protocol;

import org.jjflyboy.mpc.Command;
import org.jjflyboy.mpc.MPC;
import org.jjflyboy.mpc.Toggle;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class CommandListIT {

    private MPC mpc;
    @Before
    public void before() {
        mpc = new MPC();
    }

    @Test
    public void commands() throws IOException {
        final Command c1 = new Status();
        final Command c2 = new Random(Toggle.ON);
        final Command c3 = new Outputs();

        final CommandList.Response r = mpc.send(new CommandList(c1, c2, c3));

        assertThat(r.isOk()).isTrue();

        final java.util.List<Command.Response> responses = r.getResponses();
        assertThat(responses.get(0) instanceof Status.Response).isTrue();
        final Status.Response statusResponse = (Status.Response) responses.get(0);
        assertThat(statusResponse.getState().orElse(null)).isEqualTo("stop");
    }
}

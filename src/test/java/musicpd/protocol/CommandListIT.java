package musicpd.protocol;

import org.jjflyboy.mpc.Command;
import org.jjflyboy.mpc.MPC;
import org.jjflyboy.mpc.Toggle;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class CommandListIT {

    private MPC mpc;
    @Before
    public void before() {
        mpc = new MPC();
    }

    @Test
    public void commands() throws IOException {
        Command c1 = new Status();
        Command c2 = new Random(Toggle.ON);
        Command c3 = new Outputs();

        CommandList.Response r = mpc.send(new CommandList(c1, c2, c3));

        assertThat(r.isOk()).isTrue();

        java.util.List<Command.Response> responses = r.getResponses();
        assertThat(responses.get(0) instanceof Status.Response).isTrue();
        Status.Response statusResponse = (Status.Response) responses.get(0);
        assertThat(statusResponse.getState().get()).isEqualTo("stop");
    }
}

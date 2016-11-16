package musicpd.protocol;

import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class SetVolTest {

    @Test
    public void text() throws IOException {
        final SetVol command = new SetVol(20);
        assertThat(command.text()).as("wrong command").isEqualTo("setvol 20");
    }
}
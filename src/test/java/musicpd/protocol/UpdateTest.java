package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jfraney
 */
public class UpdateTest {
    @Test
    public void text() {
        final Update command = new Update();
        assertThat(command.text()).as("wrong command").isEqualTo("update");
    }
}
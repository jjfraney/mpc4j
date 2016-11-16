package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class UpdateTest {
    @Test
    public void text() {
        final Update command = new Update();
        assertThat(command.text()).as("wrong command").isEqualTo("update");
    }
}
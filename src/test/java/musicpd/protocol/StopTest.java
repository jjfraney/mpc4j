package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class StopTest {

    @Test
    public void text() {
        assertThat(new Stop().text()).as("wrong command").isEqualTo("stop");
    }

}
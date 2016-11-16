package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class ClearErrorTest {

    @Test
    public void text() {
        assertThat(new ClearError().text()).as("wrong command").isEqualTo("clearerror");
    }

}
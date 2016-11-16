package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class NextTest {

    @Test
    public void text() {
        assertThat(new Next().text()).as("wrong command").isEqualTo("next");
    }

}
package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class PreviousTest {

    @Test
    public void text() {
        assertThat(new Previous().text()).as("wrong command").isEqualTo("previous");
    }

}
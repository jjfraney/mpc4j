package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class MixRampDelayTest {
    @Test
    public void text() {
        assertThat(new MixRampDelay(10).text()).as("wrong command").isEqualTo("mixrampdelay 10");
    }
    @Test
    public void textNan() {
        assertThat(new MixRampDelay().text()).as("wrong command").isEqualTo("mixrampdelay nan");
    }
}
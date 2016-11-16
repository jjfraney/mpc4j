package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class ClearTest {

    @Test
    public void command() {
        final String text = new Clear().text();
        assertThat(text).isEqualTo("clear");
    }
}

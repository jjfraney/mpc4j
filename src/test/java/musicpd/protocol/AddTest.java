package musicpd.protocol;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class AddTest {

    @Test
    public void addWithUri() {
        Add a = new Add("some/path");
        String text = new Add("some/path").text();
        assertThat(text).isEqualTo("add some/path");
    }
}

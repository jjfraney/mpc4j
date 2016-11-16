package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class UnmountTest {

    @Test
    public void command() {
        final String text = new Unmount("some/path").text();
        assertThat(text).isEqualTo("unmount some/path");
    }
}

package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class MountTest {

    @Test
    public void command() {
        final String text = new Mount("some/path", "aUri").text();
        assertThat(text).isEqualTo("mount some/path aUri");
    }
}

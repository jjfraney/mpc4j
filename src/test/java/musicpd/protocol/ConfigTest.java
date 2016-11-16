package musicpd.protocol;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class ConfigTest {

    @Test
    public void commands() {
        final Config.Response r = new Config().response(Arrays.asList(
                "music_directory: some-directory",
                "OK"
        ), "OK MPD 0.19.0");
        assertThat(r.getMusicDirectory()).isPresent();
        assertThat(r.getMusicDirectory().orElse(null)).isEqualTo("some-directory");
    }
}

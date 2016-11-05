package org.jjfflyboy.mpc4j;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class ConfigTest {

    @Test
    public void commands() {
        Config.Response r = new Config().response(Arrays.asList(
                "music_directory: some-directory",
                "OK"
        ));
        assertThat(r.getMusicDirectory()).isPresent();
        assertThat(r.getMusicDirectory().get()).isEqualTo("some-directory");
    }
}

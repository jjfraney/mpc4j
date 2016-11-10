package org.jjflyboy.mpc4j;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class UnmountTest {

    @Test
    public void command() {
        String text = new Unmount("some/path").text();
        assertThat(text).isEqualTo("unmount some/path");
    }
}

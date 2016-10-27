package org.jjfflyboy.mpc4j;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class AddIdTest {

    @Test
    public void addWithUri() {
        String text = new AddId("some/path").text();
        assertThat(text).isEqualTo("addid some/path");
    }
    @Test
    public void addWithUriAndPos() {
        String text = new AddId("some/path", 10).text();
        assertThat(text).isEqualTo("addid some/path 10");
    }
}

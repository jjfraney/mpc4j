package org.jjfflyboy.mpc4j;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class UrlHandlerTest {

    @Test
    public void commands() {
        UrlHandlers.Response r = new UrlHandlers().response(Arrays.asList(
                "handler: http://",
                "handler: https://",
                "handler: smb://",
                "OK"
        ));
        java.util.List<String> commands = r.getHandlers();
        assertThat(commands.size()).isEqualTo(3);
        assertThat(commands.get(2)).isEqualTo("smb://");
    }
}

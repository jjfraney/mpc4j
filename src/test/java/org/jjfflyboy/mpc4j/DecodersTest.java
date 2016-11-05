package org.jjfflyboy.mpc4j;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class DecodersTest {

    @Test
    public void commands() {
        Decoders.Response r = new Decoders().response(Arrays.asList(
                "plugin: mad",
                "suffix: mp3",
                "suffix: mp2",
                "mime_type: audio/mpeg",
                "plugin: mpcdec",
                "suffix: mpc",
                "mime_type: audio/mpeg",
                "mime_type: application/x-diff",
                "OK"
        ));
        java.util.List<Decoders.Response.Plugin> decoders = r.getDecoders();
        assertThat(decoders.size()).isEqualTo(2);

        java.util.List<String> d1Suffixes = decoders.get(0).getSuffixes();
        assertThat(d1Suffixes.size()).isEqualTo(2);
        assertThat(d1Suffixes.get(0)).isEqualTo("mp3");

        java.util.List<String> d2Suffixes = decoders.get(1).getSuffixes();
        assertThat(d2Suffixes.size()).isEqualTo(1);
        assertThat(d2Suffixes.get(0)).isEqualTo("mpc");

        java.util.List<String> d2MimeTypes = decoders.get(1).getMimeTypes();
        assertThat(d2MimeTypes.size()).isEqualTo(2);
        assertThat(d2MimeTypes.get(1)).isEqualTo("application/x-diff");

    }
}

package org.jjfflyboy.mpc4j;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class ListPlaylistTest {

    @Test
    public void listFilesTest() {
        String responseLines [] = {
                "file: one.ogg",
                "file: two.ogg",
                "file: three.ogg",
                "OK"
        };
        ListPlaylist.Response r = new ListPlaylist("no-op").response(responseLines);
        assertThat(r.isOk()).isTrue();
        assertThat(r.getFiles().size()).isEqualTo(3);
        assertThat(r.getFiles().get(2)).isEqualTo("three.ogg");
    }
}
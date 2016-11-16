package musicpd.protocol;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class ListPlaylistTest {

    @Test
    public void listFilesTest() {
        final java.util.List<String> responseLines = Arrays.asList(
                "file: one.ogg",
                "file: two.ogg",
                "file: three.ogg",
                "OK"
        );
        final ListPlaylist.Response r = new ListPlaylist("no-op").response(responseLines, "OK MPD 0.19.0");
        assertThat(r.isOk()).isTrue();
        assertThat(r.getFiles().size()).isEqualTo(3);
        assertThat(r.getFiles().get(2)).isEqualTo("three.ogg");
    }
}

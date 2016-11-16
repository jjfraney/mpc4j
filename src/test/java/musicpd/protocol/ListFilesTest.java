package musicpd.protocol;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class ListFilesTest {
    @Test
    public void text() {
        assertThat(new LsInfo().text()).as("wrong command").isEqualTo("lsinfo");
    }

    @Test
    public void response() {
        final ListFiles.Response r = new ListFiles("dummy").response(Arrays.asList(
                "file: aaa.ogg",
                "Last-Modified: 2016-10-19T00:33:30Z",
                "size: 100",
                "directory: xxx",
                "Last-Modified: 2016-10-19T00:33:30Z",
                "size: 2100",
                "file: xxx/bbb.ogg",
                "Last-Modified: 2016-10-19T00:33:30Z",
                "size: 3100",
                "OK"
        ), "OK MPD 0.19.0");
        assertThat(r.isOk()).as("no parse").isTrue();
        final List<ListFiles.Response.Entry> entries = r.getEntries();
        assertThat(entries.size()).as("song count").isEqualTo(3);

        assertThat(entries.get(0).isFile()).isTrue();
        assertThat(entries.get(0).getFile().orElse(null)).isEqualTo("aaa.ogg");

        assertThat(entries.get(1).isDirectory()).isTrue();
        assertThat(entries.get(1).getDirectory().orElse(null)).isEqualTo("xxx");

        assertThat(entries.get(2).isFile()).isTrue();
        assertThat(entries.get(2).getFile().orElse(null)).isEqualTo("xxx/bbb.ogg");
        assertThat(entries.get(2).getSize().orElse(null)).isEqualTo(3100);
    }
}
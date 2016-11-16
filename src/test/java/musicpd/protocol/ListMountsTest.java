package musicpd.protocol;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class ListMountsTest {
    ListMounts command;
    @Before
    public void setUp() {
        command = new ListMounts();
    }

    @Test
    public void text()  {
        assertThat(command.text()).as("wrong command").isEqualTo("listmounts");
    }

    @Test
    public void testResponseParse() {
        final java.util.List<String> responseText = Arrays.asList(
                "mount:",
                "storage: /home/foo/music",
                "mount: foo",
                "storage: nfs://192.168.1.4/export/mp3"
        );
        final ListMounts.Response response = command.response(responseText, "OK MPD 0.19.0");
        final java.util.List<ListMounts.Response.Mount> mounts = response.getMounts();
        assertThat(mounts.size()).isEqualTo(2);
        assertThat(mounts.get(1).getStorage().orElse(null)).isEqualTo("nfs://192.168.1.4/export/mp3");
        assertThat(mounts.get(0).getMount()).isNotPresent();
    }
}
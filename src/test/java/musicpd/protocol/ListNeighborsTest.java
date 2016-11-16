package musicpd.protocol;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class ListNeighborsTest {
    ListNeighbors command;
    @Before
    public void setUp() {
        command = new ListNeighbors();
    }

    @Test
    public void text()  {
        assertThat(command.text()).as("wrong command").isEqualTo("listneighbors");
    }

    @Test
    public void testResponseParse() {
        final java.util.List<String> responseText = Arrays.asList(
                "neighbor: smb://FOO",
                "name: FOO (Samba 4.1.11-Debian",
                "neighbor: xyz://unknown",
                "name: UKnown"
        );
        final ListNeighbors.Response response = command.response(responseText, "OK MPD 0.19.0");
        final java.util.List<ListNeighbors.Response.Neighbor> neighbors = response.getNeighbors();
        assertThat(neighbors.size()).isEqualTo(2);
        assertThat(neighbors.get(1).getNeighbor().orElse(null)).isEqualTo("xyz://unknown");
        assertThat(neighbors.get(0).getName().orElse(null)).isEqualTo("FOO (Samba 4.1.11-Debian");
    }
}
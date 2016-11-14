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
        java.util.List<String> responseText = Arrays.asList(
                "neighbor: smb://FOO",
                "name: FOO (Samba 4.1.11-Debian",
                "neighbor: xyz://unknown",
                "name: UKnown"
        );
        ListNeighbors.Response response = command.response(responseText, "OK MPD 0.19.0");
        java.util.List<ListNeighbors.Response.Neighbor> neighbors = response.getNeighbors();
        assertThat(neighbors.size()).isEqualTo(2);
        assertThat(neighbors.get(1).getNeighbor().get()).isEqualTo("xyz://unknown");
        assertThat(neighbors.get(0).getName().get()).isEqualTo("FOO (Samba 4.1.11-Debian");
    }
}
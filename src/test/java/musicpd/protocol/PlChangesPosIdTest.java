package musicpd.protocol;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class PlChangesPosIdTest {

    @Test
    public void response() {
        final java.util.List<String> lines = Arrays.asList(
                "cpos: 1",
                "Id: 2",
                "cpos: 2",
                "Id: 3",
                "cpos: 3",
                "Id: 4",
                "OK"
        );

        final PlChangesPosId.Response r = new PlChangesPosId(3).response(lines, "OK MPD 0.19.0");
        assertThat(r.getEntries().size()).isEqualTo(3);
        assertThat(r.getEntries().get(2).getCpos().orElse(null)).isEqualTo(3);
        assertThat(r.getEntries().get(2).getId().orElse(null)).isEqualTo(4);
    }
}

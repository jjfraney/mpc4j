package musicpd.protocol;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class TagTypesTest {

    @Test
    public void commands() {
        final TagTypes.Response r = new TagTypes().response(Arrays.asList(
                "tagtype: Artist",
                "tagtype: ArtistSort",
                "tagtype: Album",
                "OK"
        ), "OK MPD 0.19.0");
        final java.util.List<String> tagTypes = r.getTagTypes();
        assertThat(tagTypes.size()).isEqualTo(3);
        assertThat(tagTypes.get(2)).isEqualTo("Album");
    }
}

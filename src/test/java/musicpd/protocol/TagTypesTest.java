package musicpd.protocol;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class TagTypesTest {

    @Test
    public void commands() {
        TagTypes.Response r = new TagTypes().response(Arrays.asList(
                "tagtype: Artist",
                "tagtype: ArtistSort",
                "tagtype: Album",
                "OK"
        ));
        java.util.List<String> tagTypes = r.getTagTypes();
        assertThat(tagTypes.size()).isEqualTo(3);
        assertThat(tagTypes.get(2)).isEqualTo("Album");
    }
}

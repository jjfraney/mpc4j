package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class SearchAddPlTest {
    @Test
    public void searchArtist() {
        final String text = new SearchAddPl("plname", Tag.ARTIST, "bob dylan").text();
        assertThat(text).as("searchaddpl artist command").isEqualTo("searchaddpl plname artist \"bob dylan\"");
    }

    @Test
    public void searchAny() {
        final String text = new SearchAddPl("plname", Find.Special.ANY, "bob dylan").text();
        assertThat(text).as("searchaddpl any command").isEqualTo("searchaddpl plname any \"bob dylan\"");
    }

    @Test
    public void searchCriteria() {
        final SearchAddPl search = SearchAddPl.build(builder -> builder
                .playlist("plname")
                .with(Tag.ARTIST, "bob dylan")
                .with(Tag.GENRE, "acid rock"));
        final String text = search.text();

        assertThat(text).as("multiple filters").isEqualTo("searchaddpl plname artist \"bob dylan\" genre \"acid rock\"");
    }

}

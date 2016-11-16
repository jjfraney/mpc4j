package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class FindTest {
    @Test
    public void findArtist() {
        final String text = new Find(Tag.ARTIST, "bob dylan").text();
        assertThat(text).as("find artist command").isEqualTo("find artist \"bob dylan\"");
    }

    @Test
    public void findAny() {
        final String text = new Find(Find.Special.ANY, "bob dylan").text();
        assertThat(text).as("find any command").isEqualTo("find any \"bob dylan\"");
    }

    @Test
    public void findCriteria() {
        final Find find = Find.build(builder -> builder
            .with(Tag.ARTIST, "bob dylan")
            .with(Tag.GENRE, "acid rock"));
        final String text = find.text();

        assertThat(text).as("multiple filters").isEqualTo("find artist \"bob dylan\" genre \"acid rock\"");
    }

    @Test
    public void searchArtist() {
        final String text = new Search(Tag.ARTIST, "bob dylan").text();
        assertThat(text).as("search artist command").isEqualTo("search artist \"bob dylan\"");
    }
}

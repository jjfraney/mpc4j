package org.jjfflyboy.mpc4j;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class FindTest {
    @Test
    public void findArtist() {
        String text = new Find(Tag.ARTIST, "bob dylan").text();
        assertThat(text).as("find artist command").isEqualTo("find artist \"bob dylan\"");
    }

    @Test
    public void findAny() {
        String text = new Find(Find.Special.ANY, "bob dylan").text();
        assertThat(text).as("find any command").isEqualTo("find any \"bob dylan\"");
    }

    @Test
    public void findCriteria() {
        Find.Term[] terms = {
                new Find.Term(Tag.ARTIST, "bob dylan"),
                new Find.Term(Tag.GENRE, "acid rock")
        };
        String text = new Find(terms).text();
        assertThat(text).as("multiple criteria").isEqualTo(("find artist \"bob dylan\" genre \"acid rock\""));
    }

    @Test
    public void searchArtist() {
        String text = new Search(Tag.ARTIST, "bob dylan").text();
        assertThat(text).as("search artist command").isEqualTo("search artist \"bob dylan\"");
    }
}

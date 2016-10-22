package org.jjfflyboy.mpc4j;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

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
        Map<Find.Type, String> criteria = new TreeMap<>();
        criteria.put(Tag.ARTIST, "bob dylan");
        criteria.put(Tag.GENRE, "acid rock");
        String text = new Find(criteria).text();
        assertThat(text).as("multiple criteria").isEqualTo(("find artist \"bob dylan\" genre \"acid rock\""));
    }

    @Test
    public void searchArtist() {
        String text = new Search(Tag.ARTIST, "bob dylan").text();
        assertThat(text).as("search artist command").isEqualTo("search artist \"bob dylan\"");
    }
}

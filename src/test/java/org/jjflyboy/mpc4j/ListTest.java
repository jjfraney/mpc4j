package org.jjflyboy.mpc4j;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class ListTest {

    private final List.Filter filterByTitle = new List.Filter(Tag.TITLE, "song title");
    private final List.Filter filterByAlbum = new List.Filter(Tag.ALBUM, "white album");

    @Test
    public void listArtist() {
        String text = new List(Tag.ARTIST).text();
        assertThat(text).as("list artist command").isEqualTo("list artist");
    }
    @Test
    public void listFile() {
        String text = new List(List.Special.FILE).text();
        assertThat(text).as("list file command").isEqualTo("list file");
    }
    @Test
    public void listSongsByArtistAlbumAndFile() {
        String text = new List(Tag.TITLE, Tag.ARTIST, Tag.ALBUM).text();
        assertThat(text).as("list title command").isEqualTo("list title group artist group album");
    }
    @Test
    public void listArtistFilterTitleAndAlbum() {
        String text = new List(Tag.ARTIST, filterByTitle, filterByAlbum).text();
        assertThat(text).as("list artist command").isEqualTo("list artist title \"song title\" album \"white album\"");
    }
    @Test
    public void listArtistFilterByTitleGroupByAlbum() {

        List list = List.build(Tag.ARTIST, c -> {
            c
                    .withFilters(filterByTitle)
                    .withGroupTypes(Tag.ALBUM);
        });
        assertThat(list.text()).as("list artist command").isEqualTo("list artist title \"song title\" group album");
    }
}

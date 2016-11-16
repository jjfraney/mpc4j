package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class ListTest {

    @Test
    public void listArtist() {
        final String text = new List(Tag.ARTIST).text();
        assertThat(text).as("list artist command").isEqualTo("list artist");
    }
    @Test
    public void listFile() {
        final String text = new List(List.Special.FILE).text();
        assertThat(text).as("list file command").isEqualTo("list file");
    }
    @Test
    public void listSongsByArtistAlbumAndFile() {
        final List list = List.build(Tag.TITLE, builder -> builder
                .groupBy(Tag.ARTIST)
                .groupBy(Tag.ALBUM));
        final String text = list.text();
        assertThat(text).as("list title command").isEqualTo("list title group artist group album");
    }
    @Test
    public void listArtistFilterTitleAndAlbum() {
        final List list = List.build(Tag.ARTIST, builder -> builder.with(Tag.TITLE, "song title")
                .with(Tag.ALBUM, "white album"));
        final String text = list.text();
        assertThat(text).as("list artist command").isEqualTo("list artist title \"song title\" album \"white album\"");
    }
    @Test
    public void listArtistFilterByTitleGroupByAlbum() {

        final List list = List.build(Tag.ARTIST, builder -> builder
                .with(Tag.TITLE, "song title")
                .groupBy(Tag.ALBUM));
        assertThat(list.text()).as("list artist command").isEqualTo("list artist title \"song title\" group album");
    }
}

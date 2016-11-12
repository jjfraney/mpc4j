package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * @author jfraney
 */
public class TagTest {

    @Test
    public void testArtist() {
        assertThat(Tag.ARTIST.toParameter()).isEqualTo("artist");
        assertThat(Tag.ARTIST.toLabel()).isEqualTo("Artist");
    }

    @Test
    public void testArtistAlbumSort() {
        assertThat(Tag.ALBUM_ARTIST_SORT.toParameter()).isEqualTo("albumartistsort");
        assertThat(Tag.ALBUM_ARTIST_SORT.toLabel()).isEqualTo("AlbumArtistSort");
    }

    @Test
    public void testMusicbrainz() {
        assertThat(Tag.MUSIC_BRAINZ_RELEASE_TRACK_ID.toParameter()).isEqualTo("musicbrainz_releasetrackid");
        assertThat(Tag.MUSIC_BRAINZ_RELEASE_TRACK_ID.toLabel()).isEqualTo("MUSICBRAINZ_RELEASETRACKID");
    }
}

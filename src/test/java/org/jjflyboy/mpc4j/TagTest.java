package org.jjflyboy.mpc4j;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * @author jfraney
 */
public class TagTest {

    @Test
    public void testArtist() {
        assertThat(Tag.ARTIST.toParameter()).isEqualTo("artist");
        assertThat(Tag.ARTIST.toSongLabel()).isEqualTo("Artist");
    }

    @Test
    public void testArtistAlbumSort() {
        assertThat(Tag.ALBUM_ARTIST_SORT.toParameter()).isEqualTo("albumartistsort");
        assertThat(Tag.ALBUM_ARTIST_SORT.toSongLabel()).isEqualTo("AlbumArtistSort");
    }

    @Test
    public void testMusicbrainz() {
        assertThat(Tag.MUSIC_BRAINZ_RELEASE_TRACK_ID.toParameter()).isEqualTo("musicbrainz_releasetrackid");
        assertThat(Tag.MUSIC_BRAINZ_RELEASE_TRACK_ID.toSongLabel()).isEqualTo("MUSICBRAINZ_RELEASETRACKID");
    }
}

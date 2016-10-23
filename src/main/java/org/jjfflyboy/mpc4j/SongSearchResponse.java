package org.jjfflyboy.mpc4j;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

/**
 * response of some database commands.
 * @author jfraney
 */
public class SongSearchResponse extends Simple.Response {

    SongSearchResponse(String[] responseLines) {
        super(responseLines);
    }

    /**
     * a Song contains only a subset of response lines limited to a single song.
     */
    public class Song extends ResponseContent {
        /**
         * @param responseLines limited to a single song
         */
        public Song(String[] responseLines) {
            super(responseLines);
        }

        public Optional<String> getFile() {
            return getStringValue("file");
        }

        public Optional<String> getRange() {
            return getStringValue("Range");
        }

        public Optional<ZonedDateTime> getLastModified() {
            return getZonedDateTimeValue("Last-Modified");
        }

        public Optional<String> getTag(Tag tag) {
            return getStringValue(tag.toSongLabel());
        }
    }

    /**
     * Isolates the response lines into distinct Songs.
     *
     * @return a list of the 'songs' identified in the response.
     */
    public List<Song> getSongs() {
        return getSubResponse(Song.class);
    }
}

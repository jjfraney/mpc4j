package org.jjfflyboy.mpc4j;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
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
        private Song(String[] responseLines) {
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
        List<Song> result = new ArrayList<>();

        // identify the indices that isolate each song, by 'file:' line
        List<Integer> fileIndices = new ArrayList<>();
        for (int i = 0; i < getResponseLines().length; i++) {
            if (getResponseLines()[i].startsWith("file:")) {
                fileIndices.add(i);
            }
        }

        // create a Song for each set of lines between the indices
        for (int i = 0; i < fileIndices.size(); i++) {
            Integer startIndex = fileIndices.get(i);
            Integer endIndex = fileIndices.size() > i + 1 ? fileIndices.get(i + 1) : getResponseLines().length - 1;

            String[] responseLinesForSong = Arrays.copyOfRange(getResponseLines(), startIndex, endIndex);
            Song song = new Song(responseLinesForSong);
            result.add(song);
        }
        return result;
    }
}

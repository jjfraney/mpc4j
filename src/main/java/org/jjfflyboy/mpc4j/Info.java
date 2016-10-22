package org.jjfflyboy.mpc4j;

import java.time.ZonedDateTime;
import java.util.*;

/**
 * Common response for accessing the song database
 * @author jfraney
 */
public abstract class Info implements Command<Info.Response> {


    @Override
    public Response response(String[] responseLines) {
        return new Response(responseLines);
    }

    public static class Response extends Simple.Response {

        Response(String[] responseLines) {
            super(responseLines);
        }

        public class Song extends ResponseContent {
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
            public Optional<String> getTag(Tag tag) {return getStringValue(tag.toSongLabel());}
        }

        public List<Song> getSongs() {
            List<Song> result = new ArrayList<>();

            // assumption: a song's response lines starts with the 'file:' line
            List<Integer> fileIndices = new ArrayList<>();
            for(int i = 0; i < getResponseLines().length; i++) {
                // get the index of every line that starts with 'file:'
                if(getResponseLines()[i].startsWith("file:")) {
                    fileIndices.add(i);
                }
            }

            for(int i = 0; i < fileIndices.size(); i++ ) {
                Integer startIndex = fileIndices.get(i);

                // startIndex may be the index for the last song
                Integer endIndex = fileIndices.size() > i + 1 ? fileIndices.get(i + 1) : getResponseLines().length - 1;
                Song song = new Song(Arrays.copyOfRange(getResponseLines(), startIndex, endIndex));
                result.add(song);
            }
            return result;
        }
    }
}

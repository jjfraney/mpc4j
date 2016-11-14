package musicpd.protocol;

import org.jjflyboy.mpc.Parameter;
import org.jjflyboy.mpc.ResponseContentParser;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * The tags implemented by MPD.  They appear in command parameters and response labels.
 * @author jfraney
 */
public enum Tag implements Parameter, ResponseContentParser.LineMetadata {
    ARTIST,
    ARTIST_SORT,
    ALBUM,
    ALBUM_SORT,
    ALBUM_ARTIST,
    ALBUM_ARTIST_SORT,
    TITLE,
    TRACK,
    NAME,
    GENRE,
    DATE,
    COMPOSER,
    PERFORMER,
    COMMENT,
    DISC,
    MUSIC_BRAINZ_ARTIST_ID("MUSICBRAINZ_ARTISTID"),
    MUSIC_BRAINZ_ALBUM_ID("MUSICBRAINZ_ALBUMID"),
    MUSIC_BRAINZ_ALBUM_ARTIST_ID("MUSICBRAINZ_ALBUMARTISTID"),
    MUSIC_BRAINZ_TRACK_ID("MUSICBRAINZ_TRACKID"),
    MUSIC_BRAINZ_RELEASE_TRACK_ID("MUSICBRAINZ_RELEASETRACKID");

    private String label;
    private String parameter;

    Tag(String label) {
        this.label = label;
        this.parameter = this.label.toLowerCase();
    }
    Tag() {
        // convert Tag's name (CAPS and underscores) to camelCase
        String [] tokens = name().split("_");
        this.label = Arrays.stream(tokens).map(Tag::capitalize).collect(Collectors.joining(""));
        this.parameter = this.label.toLowerCase();
    }

    /**
     * @param segment in uppercase
     * @return a capitalized segment (all lowercase except first letter)
     */
    private static String capitalize(String segment) {
        return new StringBuffer()
                .append(Character.toUpperCase(segment.charAt(0)))
                .append(segment.substring(1, segment.length()).toLowerCase())
                .toString();
    }

    /**
     * @return the tag as it would appear as a label in a response.
     */
    @Override
    public String toLabel() {
        return label;
    }

    /**
     * @return the tag as it would appear as a command parameter
     */
    @Override
    public String toParameter() {
        return parameter;
    }
}
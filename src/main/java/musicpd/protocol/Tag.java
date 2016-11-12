package musicpd.protocol;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * The tags implemented by MPD.
 * <p>
 *     A Tag is also a TYPE for the find command, and a TAG for the count command,
 *     and a GROUPTYPE for the list command.
 * </p>
 * @see musicpd.protocol.Find.Type
 * @see musicpd.protocol.Count.Tag
 * @see musicpd.protocol.List.Type
 * @see musicpd.protocol.PlaylistFind.Tag
 * @author jfraney
 */
public enum Tag implements Parameter, Find.Type, Count.Tag, List.Type, PlaylistFind.Tag {
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
     * @return the tag as it would appear in response from database search commands.
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
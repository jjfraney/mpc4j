package org.jjflyboy.mpc4j;

/**
 * searchaddpl command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>MPD Document: The music database.</a>
 * <p>
 *     On this command, mpd returns database metadata for each song.
 * </p>
 * @author jfraney
 */
public class SearchAddPl extends Find {

    private final String playlistName;

    /**
     * a command of form: 'searchaddpl {Name} {TYPE} "{WHAT}"
     * @param type name of field to match
     * @param what value to match
     */
    public SearchAddPl(String playlistName, Type type, String what) {
        super(type, what);
        if(playlistName == null) {
            throw new RuntimeException("playlistName cannot be null");
        }
        this.playlistName = playlistName;
    }

    /**
     * a command of form: 'searchaddpl {NAME} {TYPE} "{WHAT}" [...]'.
     * @param playlistName
     * @param filters array of TYPE-WHAT filter pairs.
     */
    public SearchAddPl(String playlistName, Filter... filters) {
        super(filters);
        this.playlistName = playlistName;
    }

}

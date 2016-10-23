package org.jjfflyboy.mpc4j;

import java.util.Map;

/**
 * @author jfraney
 */
public class SearchAddPl extends Find {

    private final String playlistName;

    /**
     * a command of form: 'searchaddpl {Name} {TYPE} "{WHAT}"
     * @param type
     * @param what
     */
    public SearchAddPl(String playlistName, Find.Type type, String what) {
        super(type, what);
        if(playlistName == null) {
            throw new RuntimeException("playlistName cannot be null");
        }
        this.playlistName = playlistName;
    }

    /**
     * a command of form: 'searchaddpl {TYPE} "{WHAT}" [...]'.
     * The arguments appear according to the ordering rule of the map.
     * @param parameters ordered or unordered map: (type, what).
     */
    public SearchAddPl(String playlistName, Map<Find.Type, String> parameters) {
        super(parameters);
        if(playlistName == null) {
            throw new RuntimeException("playlistName cannot be null");
        }
        this.playlistName = playlistName;
    }

    @Override
    public String text() {
        return "searchaddpl " + playlistName + " " + getCriteria().toParameters();
    }
}

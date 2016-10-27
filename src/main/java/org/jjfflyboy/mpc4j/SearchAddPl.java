package org.jjfflyboy.mpc4j;

import java.util.Arrays;
import java.util.List;

/**
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

    @Override
    public String text() {
        return "searchaddpl " + playlistName + " " + getFilters().toParameters();
    }
}

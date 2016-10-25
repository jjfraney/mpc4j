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
     * a command of form: 'searchaddpl {NAME} {TYPE} "{WHAT}" [...]'.
     * @param playlistName
     * @param terms list of (type, what).
     */
    public SearchAddPl(String playlistName, List<Find.Term> terms) {
        super(terms);
        if(playlistName == null) {
            throw new RuntimeException("playlistName cannot be null");
        }
        this.playlistName = playlistName;
    }

    public SearchAddPl(String playlistName, Find.Term... terms) {
        this(playlistName, Arrays.asList(terms));
    }

    @Override
    public String text() {
        return "searchaddpl " + playlistName + " " + getCriteria().toParameters();
    }
}

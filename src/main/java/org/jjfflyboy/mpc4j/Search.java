package org.jjfflyboy.mpc4j;

import java.util.Map;

/**
 * @author jfraney
 */
public class Search extends Find {

    /**
     * a command of form: 'search {TYPE} "{WHAT}"
     * @param type
     * @param what
     */
    public Search(Find.Type type, String what) {
        super(type, what);
    }

    /**
     * a command of form: 'searc {TYPE} "{WHAT}" [...]'.
     * The arguments appear according to the ordering rule of the map.
     * @param parameters ordered or unordered map: (type, what).
     */
    public Search(Map<Find.Type, String> parameters) {
        super(parameters);
    }

    @Override
    public String text() {
        return "search " + getCriteria().toParameters();
    }
}

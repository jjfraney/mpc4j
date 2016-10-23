package org.jjfflyboy.mpc4j;

import java.util.Map;

/**
 * @author jfraney
 */
public class SearchAdd extends Find {

    /**
     * a command of form: 'searchadd {TYPE} "{WHAT}"
     * @param type
     * @param what
     */
    public SearchAdd(Find.Type type, String what) {
        super(type, what);
    }

    /**
     * a command of form: 'searchadd {TYPE} "{WHAT}" [...]'.
     * The arguments appear according to the ordering rule of the map.
     * @param parameters ordered or unordered map: (type, what).
     */
    public SearchAdd(Map<Find.Type, String> parameters) {
        super(parameters);
    }

    @Override
    public String text() {
        return "searchadd " + getCriteria().toParameters();
    }
}

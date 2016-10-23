package org.jjfflyboy.mpc4j;

import java.util.Map;

/**
 * @author jfraney
 */
public class FindAdd extends Find {

    /**
     * a command of form: 'findadd {TYPE} "{WHAT}"
     * @param type
     * @param what
     */
    public FindAdd(Find.Type type, String what) {
        super(type, what);
    }

    /**
     * a command of form: 'findadd {TYPE} "{WHAT}" [...]'.
     * The arguments appear according to the ordering rule of the map.
     * @param parameters ordered or unordered map: (type, what).
     */
    public FindAdd(Map<Find.Type, String> parameters) {
        super(parameters);
    }

    @Override
    public String text() {
        return "findadd " + getCriteria().toParameters();
    }
}

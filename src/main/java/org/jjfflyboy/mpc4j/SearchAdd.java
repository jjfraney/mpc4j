package org.jjfflyboy.mpc4j;

import java.util.List;

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
     * @param terms list of (type, what).
     */
    public SearchAdd(List<Find.Term> terms) {
        super(terms);
    }
    public SearchAdd(Find.Term... terms) {
        super(terms);
    }

    @Override
    public String text() {
        return "searchadd " + getCriteria().toParameters();
    }
}

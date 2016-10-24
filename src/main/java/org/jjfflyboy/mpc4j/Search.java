package org.jjfflyboy.mpc4j;

import java.util.List;

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
     * @param terms ordered or unordered map: (type, what).
     */
    public Search(List<Criteria.Term> terms) {
        super(terms);
    }
    public Search(Criteria.Term... terms) {
        super(terms);
    }

    @Override
    public String text() {
        return "search " + getCriteria().toParameters();
    }
}

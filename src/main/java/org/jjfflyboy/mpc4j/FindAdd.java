package org.jjfflyboy.mpc4j;

import java.util.List;

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
     * @param terms list of : (type, what).
     */
    public FindAdd(List<Criteria.Term> terms) {
        super(terms);
    }
    public FindAdd(Criteria.Term... terms) {
        super(terms);
    }
    @Override
    public String text() {
        return "findadd " + getCriteria().toParameters();
    }
}

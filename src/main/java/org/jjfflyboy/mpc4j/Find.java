package org.jjfflyboy.mpc4j;

import java.util.List;

/**
 * Support the find command.
 * <p>
 *     note: the only mpd protocol document (https://www.musicpd.org/doc/protocol/database.html)
 *     identifies 'window' option.
 *     A live mpd server fails to parse a command with 'window' option.
 *     The source code for mpd version 0.19.x does not have 'window' option.
 *     So, there is not support for 'window' option here.
 *
 * </p>
 * @author jfraney
 */
public class Find extends AbstractSongSearch {

    interface Type extends Criteria.Type {
    }

    public enum Special implements Find.Type {
        ANY, FILE, BASE, MODIFIED_SINCE;

        @Override
        public String toParameter() {
            switch(this) {
                case MODIFIED_SINCE:
                    return "modified-since";
                default:
                    return name().toLowerCase();
            }
        }
    }

    private final Criteria criteria;

    /**
     * a command of form: 'find {TYPE} "{WHAT}"'
     * @param type
     * @param what
     */
    public Find(Find.Type type, String what) {
        Criteria.Term term = new Criteria.Term(type, what);
        criteria = new Criteria(term);
    }

    /**
     * a command of form: 'find {TYPE} "{WHAT}" [...]'.
     * @param terms array of terms: {TYPE} {WHAT}.
     */
    public Find(Criteria.Term... terms) {
        criteria = new Criteria(terms);
    }
    public Find(List<Criteria.Term> terms) {
        criteria = new Criteria(terms);
    }

    @Override
    public String text() {
        return "find " + getCriteria().toParameters();
    }

    protected Criteria getCriteria() {
        return criteria;
    }
}

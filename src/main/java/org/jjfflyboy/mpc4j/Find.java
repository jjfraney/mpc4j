package org.jjfflyboy.mpc4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
        Map<Criteria.Type, String> m = new HashMap<>();
        m.put(type, what);
        criteria = new Criteria(m);
    }

    /**
     * a command of form: 'find {TYPE} "{WHAT}" [...]'.
     * The arguments appear according to the ordering rule of the map.
     * @param parameters ordered or unordered map: (type, what).
     */
    public Find(Map<Find.Type, String> parameters) {
        criteria = new Criteria(parameters);
    }

    @Override
    public String text() {
        return "find " + getCriteria().toParameters();
    }

    protected Criteria getCriteria() {
        return criteria;
    }
}

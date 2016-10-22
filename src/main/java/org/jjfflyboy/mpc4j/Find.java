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
    interface Type {
        /**
         * convert the type to string as it would appear in mpd command.
         * @return
         */
        String toParameter();
    }

    public enum Special implements Type {
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

    private final Map<Type, String> criteria;

    /**
     * a command of form: 'find {TYPE} "{WHAT}"'
     * @param type
     * @param what
     */
    public Find(Type type, String what) {
        Map<Type, String> m = new HashMap<>();
        m.put(type, what);
        criteria = Collections.unmodifiableMap(m);
    }

    /**
     * a command of form: 'find {TYPE} "{WHAT}" [...]'.
     * The arguments appear according to the ordering rule of the map.
     * @param parameters ordered or unordered map: (type, what).
     */
    public Find(Map<Type, String> parameters) {
        criteria = Collections.unmodifiableMap(parameters);
    }

    @Override
    public String text() {
        return "find " + flatten(getCriteria());
    }

    protected Map<Type, String> getCriteria() {
        return criteria;
    }

    /**
     * flattens the map to: "type what [....]"
     * @param map
     * @return
     */
    protected String flatten(Map<? extends Type, String> map) {
        String result = map
                .entrySet()
                .stream()
                .map(this::flatten)
                .collect(Collectors.joining(" "));
        return result;

    }
    private String flatten(Map.Entry<? extends Type, String> e) {
        return new StringBuilder()
                .append(e.getKey().toParameter())
                .append(" ")
                .append('"')
                .append(e.getValue())
                .append('"')
                .toString();
    }
}

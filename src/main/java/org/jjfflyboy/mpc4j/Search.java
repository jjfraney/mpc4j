package org.jjfflyboy.mpc4j;

import java.util.List;

/**
 * @author jfraney
 */
public class Search extends Find {

    /**
     * a command of form: 'search {TYPE} "{WHAT}"
     * @param type name of field to match
     * @param what value to match
     */
    public Search(Type type, String what) {
        super(type, what);
    }

    /**
     * a command of form: 'search {TYPE} "{WHAT}" [...]'.
     * @param filters array of TYPE-WHAT filter pairs.
     */
    public Search(List<Filter> filters) {
        super(filters);
    }
    /**
     * a command of form: 'search {TYPE} "{WHAT}" [...]'.
     * @param filters array of TYPE-WHAT filter pairs.
     */
    public Search(Filter... filters) {
        super(filters);
    }

    @Override
    public String text() {
        return "search " + getFilters().toParameters();
    }
}

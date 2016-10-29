package org.jjfflyboy.mpc4j;

import java.util.List;

/**
 * @author jfraney
 */
public class FindAdd extends Find {

    /**
     * a command of form: 'findadd {TYPE} "{WHAT}"
     * @param type name of field to match
     * @param what value to match
     */
    public FindAdd(Type type, String what) {
        super(type, what);
    }

    /**
     * a command of form: 'findadd {TYPE} "{WHAT}" [...]'.
     * @param filters array of TYPE-WHAT filter pairs.
     */
    public FindAdd(Filter... filters) {
        super(filters);
    }
}

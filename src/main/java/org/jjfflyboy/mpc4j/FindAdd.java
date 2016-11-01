package org.jjfflyboy.mpc4j;

import java.util.List;

/**
 * findadd command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>MPD Document: The music database.</a>
 * <p>
 *     On this command, mpd returns database metadata for each song.
 * </p>
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

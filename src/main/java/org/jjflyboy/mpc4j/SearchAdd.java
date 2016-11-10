package org.jjflyboy.mpc4j;

/**
 * searchadd command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>MPD Document: The music database.</a>
 * <p>
 *     On this command, mpd returns database metadata for each song.
 * </p>
 * @author jfraney
 */
public class SearchAdd extends Find {

    /**
     * a command of form: 'searchadd {TYPE} "{WHAT}"
     * @param type name of field to match
     * @param what value to match
     */
    public SearchAdd(Type type, String what) {
        super(type, what);
    }

    /**
     * a command of form: 'searchadd {TYPE} "{WHAT}" [...]'.
     * @param filters array of TYPE-WHAT filter pairs.
     */
    public SearchAdd(Filter... filters) {
        super(filters);
    }

}

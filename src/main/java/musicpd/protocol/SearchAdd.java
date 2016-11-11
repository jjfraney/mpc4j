package musicpd.protocol;

/**
 * searchadd command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>MPD Document: The music database.</a>
 * <p>
 *     On this command, mpd returns database metadata for each song.
 * </p>
 * @author jfraney
 */
public class SearchAdd extends DatabaseQuery {

    /**
     * a command of form: 'searchadd {TYPE} "{WHAT}"
     * @param type name of field to match
     * @param what value to match
     */
    public SearchAdd(Find.Type type, String what) {
        super(new Find.Filter(type, what));
    }

    /**
     * a command of form: 'searchadd {TYPE} "{WHAT}" [...]'.
     * @param filters array of TYPE-WHAT filter pairs.
     */
    public SearchAdd(Find.Filter... filters) {
        super(filters);
    }

}

package musicpd.protocol;

/**
 * findadd command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>MPD Document: The music database.</a>
 * <p>
 *     On this command, mpd returns database metadata for each song.
 * </p>
 * @author jfraney
 */
public class FindAdd extends DatabaseQuery {

    /**
     * a command of form: 'findadd {TYPE} "{WHAT}"
     * @param type name of field to match
     * @param what value to match
     */
    public FindAdd(Find.Type type, String what) {
        super(new Find.Filter(type, what));
    }

    /**
     * a command of form: 'findadd {TYPE} "{WHAT}" [...]'.
     * @param filters array of TYPE-WHAT filter pairs.
     */
    public FindAdd(Find.Filter... filters) {
        super(filters);
    }
}

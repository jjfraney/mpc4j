package musicpd.protocol;

import org.jjflyboy.mpc.DatabaseQuery;
import org.jjflyboy.mpc.FilterParameter;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * findadd command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>
 *     MPD Document: The music database.</a>
 * <p>
 *     On this command, mpd returns database metadata for each song.
 * </p>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class FindAdd extends DatabaseQuery {

    /**
     * a command of form: 'findadd {TYPE} "{WHAT}"
     * @param type name of field to match
     * @param what value to match
     */
    public FindAdd(final Tag type, final String what) {
        super(new FilterParameter(type, what));
    }
    /**
     * a command of form: 'findadd {TYPE} "{WHAT}"
     * @param type name of field to match
     * @param what value to match
     */
    public FindAdd(final Find.Special type, final String what) {
        super(new FilterParameter(type, what));
    }

    private FindAdd(final java.util.List<FilterParameter> filters) {
        super(new ArrayList<>(filters));
    }

    public static class Builder extends Find.AbstractBuilder<Builder, FindAdd> {
        @Override
        protected FindAdd build() {
            return new FindAdd(getFilters());
        }
    }

    public static FindAdd build(final Consumer<Builder> c) {
        final Builder b = new Builder();
        c.accept(b);
        return b.build();
    }
}

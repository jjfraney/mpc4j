package musicpd.protocol;

import org.jjflyboy.mpc.DatabaseQuery;
import org.jjflyboy.mpc.FilterParameter;

import java.util.ArrayList;
import java.util.function.Consumer;

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
    public FindAdd(Tag type, String what) {
        super(new FilterParameter(type, what));
    }
    /**
     * a command of form: 'findadd {TYPE} "{WHAT}"
     * @param type name of field to match
     * @param what value to match
     */
    public FindAdd(Find.Special type, String what) {
        super(new FilterParameter(type, what));
    }

    private FindAdd(java.util.List<FilterParameter> filters) {
        super(new ArrayList<>(filters));
    }

    public static class Builder extends Find.AbstractBuilder<Builder, FindAdd> {
        @Override
        protected FindAdd build() {
            return new FindAdd(getFilters());
        }
    }

    public static FindAdd build(Consumer<Builder> c) {
        Builder b = new Builder();
        c.accept(b);
        return b.build();
    }
}

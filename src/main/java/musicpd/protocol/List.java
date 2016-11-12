package musicpd.protocol;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * list command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>MPD Document: The music database.</a>
 * <p>
 *     TODO: the response to this command is not wrapped yet.
 * </p>
 * @author jfraney
 */
public class List extends AbstractCommand<List.Response> {

    /**
     * TYPE: can be any tag or 'file'.
     * @see musicpd.protocol.Tag
     * @see musicpd.protocol.List.Special
     */
    interface Type extends FilterParameter.Type, ResponseContentParser.LineMetadata {
    }

    /**
     * List command allows also for 'file'.
     */
    public enum Special implements List.Type {
        FILE;

        @Override
        public String toParameter() {
            return name().toLowerCase();
        }

        @Override
        public String toLabel() {return name().toLowerCase();}
    }

    /**
     * list the tag or 'file' on all songs.
     * @param type the 'type' to list
     */
    public List(final List.Type type) {
        super(type);
    }

    @Override
    public Response response(java.util.List<String> responseLines) {
        return new Response(responseLines);
    }

    public class Response extends HealthResponse {
        Response(java.util.List<String> responseLines) {
            super(responseLines);
        }

        // TODO: how to structure the response lines?

    }

    /**
     * build a 'list' Command with arbitrary arguments.
     */
    public static class Builder {
        private final List.Type type;
        private java.util.List<FilterParameter> filters = new ArrayList<>();
        private java.util.List<Tag> groups = new ArrayList<>();

        private Builder(List.Type type) {
            this.type = type;
            if(type == null) {
                throw new IllegalArgumentException("at least one {TYPE} is required.");
            }
        }

        /**
         * can be called multiple times.
         * @param filterType the type to filter
         * @param filterWhat the string to filter
         * @return this builder
         */
        public Builder with(Find.Type filterType, String filterWhat) {
            filters.add(new FilterParameter(filterType, filterWhat));
            return this;
        }

        /**
         * can be called multiple times.
         * @param tag to group by
         * @return this builder
         */
        public Builder groupBy(Tag tag) {
            groups.add(tag);
            return this;
        }

        public List build() {
            return new List(type, filters, groups);
        }
    }

    private List(List.Type type, java.util.List<FilterParameter> filters, java.util.List<Tag> tags) {
        super(type, adapt(new ArrayList<>(filters)), new GroupParameter(tags));
    }
    /**
     * build a list command
     * @param type not-null tag or 'file' to list
     * @param c consumer providing the fields the the command
     * @return a List command
     */
    public static List build(List.Type type, Consumer<Builder> c) {
        Builder b = new Builder(type);
        c.accept(b);
        return b.build();
    }
}

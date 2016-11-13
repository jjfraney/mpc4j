package musicpd.protocol;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.logging.Filter;
import java.util.stream.Collectors;

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
     */

    /**
     * List command allows also for 'file'.
     */
    public enum Special implements Parameter, ResponseContentParser.LineMetadata {
        FILE;

        @Override
        public String toParameter() {
            return name().toLowerCase();
        }

        @Override
        public String toLabel() {return name().toLowerCase();}
    }

    // this first argument is the leading line of each item in the matching list.
    private final ResponseContentParser.LineMetadata type;

    /**
     * list the tag or 'file' on all songs.
     * @param type the 'type' to list
     * @see musicpd.protocol.Tag
     */
    public List(final Tag type) {
        super(type);
        this.type = type;
    }
    /**
     * list the tag or 'file' on all songs.
     * @param type the 'type' to list
     * @see musicpd.protocol.List.Special
     */
    public List(final List.Special type) {
        super(type);
        this.type = type;
    }

    @Override
    public Response response(java.util.List<String> responseLines) {
        return new Response(responseLines);
    }

    public class Response extends HealthResponse {
        Response(java.util.List<String> responseLines) {
            super(responseLines);
        }

        /**
         * the metadata in List response.
         * <p>
         *     The response is not full metadata, as in 'find' command.
         *     The response is sparse.
         *     Only the types identified in the command parameters appear in the response.
         * </p>
         */
        public class Metadata extends ResponseContent {

            Metadata(java.util.List<String> responseLines) {
                super(responseLines);
            }

            /**
             * get the value for the line with the matching label.
             * <p>
             *     Expect only the types in the 'list' parameters to have value.
             *     Even those may not be present.
             * </p>
             * @param type of interest
             * @return the value of the string with the label matching 'type'
             * @see musicpd.protocol.Tag
             */
            public Optional<String> getType(Tag type) {
                return getStringValue(type);
            }
            /**
             * get the value for the line with the matching label.
             * <p>
             *     Expect only the types in the 'list' parameters to have value.
             *     Even those may not be present.
             * </p>
             * @param type of interest
             * @return the value of the string with the label matching 'type'
             * @see musicpd.protocol.List.Special
             */
            public Optional<String> getType(Special type) {
                return getStringValue(type);
            }
        }

        /**
         * @return response of list command segmented by the 'type' parameter
         */
        public java.util.List<Metadata> getMetadata() {
            return segments(type)
                    .stream()
                    .map(Metadata::new)
                    .collect(Collectors.toList());
        }
    }

    /**
     * build a 'list' Command with arbitrary arguments.
     */
    public static class Builder {
        private final Tag typeAsTag;
        private final Special typeAsSpecial;

        private java.util.List<FilterParameter> filters = new ArrayList<>();
        private java.util.List<Tag> groups = new ArrayList<>();

        private Builder(Tag type) {
            this.typeAsTag = type;
            this.typeAsSpecial = null;
            if(type == null) {
                throw new IllegalArgumentException("at least one {TYPE} is required.");
            }
        }
        private Builder(Special type) {
            this.typeAsTag = null;
            this.typeAsSpecial = type;
            if(type == null) {
                throw new IllegalArgumentException("at least one {TYPE} is required.");
            }
        }

        /**
         * @param filterType the type to filter
         * @param filterWhat the string to filter
         * @return this builder
         * @see musicpd.protocol.Tag
         */
        public Builder with(Tag filterType, String filterWhat) {
            filters.add(new FilterParameter(filterType, filterWhat));
            return this;
        }
        /**
         * @param filterType the type to filter
         * @param filterWhat the string to filter
         * @return this builder
         * @see musicpd.protocol.List.Special
         */
        public Builder with(Find.Special filterType, String filterWhat) {
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
            if(typeAsSpecial == null) {
                return new List(typeAsTag, filters, groups);
            } else {
                return new List(typeAsSpecial, filters, groups);
            }
        }
    }

    private List(Tag type, java.util.List<FilterParameter> filters, java.util.List<Tag> tags) {
        super(type, adapt(new ArrayList<>(filters)), new GroupParameter(tags));
        this.type = type;
    }
    private List(Special type, java.util.List<FilterParameter> filters, java.util.List<Tag> tags) {
        super(type, adapt(new ArrayList<>(filters)), new GroupParameter(tags));
        this.type = type;
    }

    /**
     * build a list command
     * @param type not-null tag to list
     * @param builder consumer providing the fields of the command
     * @return a List command
     * @see musicpd.protocol.Tag
     */
    public static List build(Tag type, Consumer<Builder> builder ) {
        return build(new Builder(type), builder);
    }
    /**
     * build a list command
     * @param type not-null special-type to list
     * @param builder consumer providing the fields of the command
     * @return a List command
     * @see musicpd.protocol.List.Special
     */
    public static List build(Special type, Consumer<Builder> builder ) {
        return build(new Builder(type), builder);
    }

    private static List build(Builder b, Consumer<Builder> c) {
        c.accept(b);
        return b.build();
    }

}

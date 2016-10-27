package org.jjfflyboy.mpc4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Represents the 'list' command.  A list command's form is:
 * <pre>"list {TYPE} [FILTERTYPE] [FILTERWHAT] [...] [group] [GROUPTYPE] [...]"</pre>
 *
 * @author jfraney
 */
public class List implements Command<List.Response> {

    /**
     * TYPE: can be any tag or 'file'.
     */
    interface Type {
        String toParameter();
        String toSongLabel();
    }
    public enum Special implements List.Type {
        FILE;

        @Override
        public String toParameter() {
            return name().toLowerCase();
        }

        @Override
        public String toSongLabel() {return name().toLowerCase();}
    }

    /**
     * any tag or 'file'.
     */
    private final List.Type type;

    public static class Filter extends Filters.Filter {

        protected Filter(Find.Type type, String what) {
            super(type, what);
        }
    }
    private final Filters filters;

    /**
     * any tag
     */
    private final Tag [] groupTypes;

    private static List.Filter[] NO_FILTERS = new List.Filter[0];
    private static Tag [] NO_GROUPTYPES = new Tag [0];

    /**
     * list the tag or 'file' on all songs.
     * @param type the 'type' to list
     */
    public List(final List.Type type) {
        this.filters = new Filters(NO_FILTERS);
        this.type = type;
        this.groupTypes = NO_GROUPTYPES;
    }

    /**
     * list the tag or 'file' on songs that pass the filters.
     * @param type the 'type' to list
     * @param filters filters to apply
     */
    public List(List.Type type, List.Filter ... filters) {
        this.filters = new Filters(filters);
        this.type = type;
        this.groupTypes = NO_GROUPTYPES;
    }

    /**
     * list the tag or 'file' on all songs, grouped.
     * @param type the 'type' to list
     * @param groupTypes tags to group by
     */
    public List(List.Type type, Tag ... groupTypes) {
        this.filters = new Filters(NO_FILTERS);
        this.type = type;
        this.groupTypes = groupTypes;
    }

    /**
     * list the tag or 'file' on songs that pass the filters, grouped.
     * @param type the 'type' to list
     * @param filters filters to apply
     * @param groupTypes tags to group by
     */
    public List(List.Type type, List.Filter[] filters, Tag[] groupTypes) {
        this.filters = new Filters(filters);
        this.type = type;
        this.groupTypes = groupTypes;
    }
    @Override
    public String text() {
        StringBuilder sb = new StringBuilder()
                .append("list ")
                .append(type.toParameter());
        String filtersString = this.filters.toParameters();
        if(filtersString.length() > 0) {
            sb.append(" ").append(filtersString);
        }
        if(groupTypes.length > 0) {
            String groupsString = Arrays.stream(groupTypes).map(g-> "group " + g.toParameter()).collect(Collectors.joining(" "));
            sb.append(" ").append(groupsString);
        }
        return sb.toString();
    }

    @Override
    public Response response(String[] responseLines) {
        return new Response(responseLines);
    }

    public class Response extends Simple.Response {
        Response(String[] responseLines) {
            super(responseLines);
        }

        // TODO: how to structure the response lines?

    }

        /**
     * build a 'list' Command with arbitrary arguments.
     */
    public static class Builder {

        private final List.Type type;
        private Filter[] filters;
        private Tag [] groupTypes;

        private Builder(List.Type type) {
            if(type == null) {
                throw new IllegalArgumentException("type must not be null.");
            }
            this.type = type;
        }

        /**
         * @param filters filters to apply
         * @return this builder
         */
        public Builder withFilters(List.Filter ... filters) {
            this.filters = filters;
            return this;
        }

        /**
         *
         * @param groupTypes tags to group by
         * @return
         */
        public Builder withGroupTypes(Tag ... groupTypes) {
            this.groupTypes = groupTypes;
            return this;
        }
        public List build() {
            if(filters == null) {
                filters = NO_FILTERS;
            }
            if(groupTypes == null) {
                groupTypes = NO_GROUPTYPES;
            }
            return new List(type, filters, groupTypes);
        }
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

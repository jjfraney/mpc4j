package org.jjfflyboy.mpc4j;

import java.util.*;

/**
 * @author jfraney
 */
public class Count extends Simple {

    /**
     * The domain for the TAG parameter of 'count' command.
     */
    interface Tag extends Filters.Field {
    }

    public static class Filter extends Filters.Filter {

        protected Filter(Count.Tag tag, String value) {
            super(tag, value);
        }
    }

    private final Filters filters;
    private final org.jjfflyboy.mpc4j.Tag group;

    /**
     * a command of form: 'count {TAG} "{NEEDLE}"'.
     * @param tag name of tag to match
     * @param needle value to match
     */
    public Count(Tag tag, String needle) {
        filters = new Filters(new Filter(tag, needle));
        group = null;
    }
    /**
     * a command of form: 'count {TAG} "{NEEDLE}" [...]'.
     * @param filters list of TYPE-WHAT filter pairs.
     */
    public Count(List<Filter> filters) {
        this.filters = new Filters(filters);
        group = null;
    }
    /**
     * a command of form: 'count {TAG} "{NEEDLE}" [...]'.
     * @param filters array of TYPE-WHAT filter pairs.
     */
    public Count(Filter... filters) {
        this.filters = new Filters(filters);
        group = null;
    }

    /**
     * a command of form: 'count {TAG} "{NEEDLE}"'.
     * @param tag field name to match
     * @param needle value to match
     * @param group optional value to group results by, null if none.
     */
    public Count(Tag tag, String needle, org.jjfflyboy.mpc4j.Tag group) {
        filters = new Filters(new Filter(tag, needle));
        this.group = group;
    }

    /**
     *
     * @param filters list of TYPE-WHAT filter pairs.
     * @param group optional value to group results by, null if none.
     */
    public Count(List<Filter> filters, org.jjfflyboy.mpc4j.Tag group) {
        this.filters = new Filters(filters);
        this.group = group;
    }

    /**
     *
     * @param filters array of TYPE-WHAT filter pairs.
     * @param group optional value to group results by, null if none.
     */
    public Count(Filter[] filters, org.jjfflyboy.mpc4j.Tag group) {
        this.filters = new Filters(filters);
        this.group = group;
    }

    /**
     *
     * @param group optional value to group results by, null if none.
     * @param filters array of TYPE-WHAT filter pairs.
     */
    public Count(org.jjfflyboy.mpc4j.Tag group, Filter... filters) {
        this(filters, group);
    }

    @Override
    public String text() {
        StringBuilder sb = new StringBuilder()
                .append("count ")
                .append(filters.toParameters());
        if(group != null) {
            sb.append(" group ").append(group.toParameter());
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

        /**
         * @return if group was not specified, empty Optional, else the value for the 'songs' responseline.
         */
        public Optional<Integer> getSongs() {
            if(group != null) {
                return Optional.empty();
            } else {
              return getIntegerValue("songs");
            }
        }
        /**
         * @return if group was not specified, empty Optional, else the value for the 'songs' responseline.
         */
        public Optional<Integer> getPlaytime() {
            if(group != null) {
                return Optional.empty();
            } else {
                return getIntegerValue("playtime");
            }
        }

        public class Group extends ResponseContent {
            /**
             * @param responseLines limited to a single group
             */
            public Group(String[] responseLines) {
                super(responseLines);
            }

            public Optional<Integer> getSongs() {
                return getIntegerValue("songs");
            }

            public Optional<Integer> getPlaytime() {
                return getIntegerValue("playtime");
            }

            public Optional<String> getTag(org.jjfflyboy.mpc4j.Tag tag) {
                return getStringValue(tag.toSongLabel());
            }
        }

        /**
         * @return if group not specified, empty list, else groups of response lines as Group.
         */
        public List<Group> getGroups() {
            if(group == null) {
                return Collections.emptyList();
            } else {
                return getSubResponse(Group.class);
            }
        }
    }
}

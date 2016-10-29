package org.jjfflyboy.mpc4j;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author jfraney
 */
public class Count extends AbstractCommand<Count.Response> {

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

    private final boolean isGrouped;
    /**
     * a command of form: 'count {TAG} "{NEEDLE}"'.
     * @param tag name of tag to match
     * @param needle value to match
     */
    public Count(Tag tag, String needle) {
        super(new Filters(new Filter(tag, needle)));
        isGrouped = false;
    }
    /**
     * a command of form: 'count {TAG} "{NEEDLE}" [...]'.
     * @param filters array of TYPE-WHAT filter pairs.
     */
    public Count(Filter... filters) {
        super(new Filters(filters));
        isGrouped = false;
    }

    /**
     * a command of form: 'count {TAG} "{NEEDLE}"'.
     * @param tag field name to match
     * @param needle value to match
     * @param group optional value to group results by, null if none.
     */
    public Count(Tag tag, String needle, org.jjfflyboy.mpc4j.Tag group) {
        super(new Filters(new Filter(tag, needle)), new GroupParameter(group));
        isGrouped = true;
    }

    /**
     *
     * @param filters array of TYPE-WHAT filter pairs.
     * @param group optional value to group results by, null if none.
     */
    public Count(Filter[] filters, org.jjfflyboy.mpc4j.Tag group) {
        super(new Filters(filters), new GroupParameter(group));
        isGrouped = true;
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
    public Response response(String[] responseLines) {
        return new Response(responseLines);
    }

    public class Response extends SimpleResponse {
        Response(String[] responseLines) {
            super(responseLines);
        }

        /**
         * @return if group was not specified, empty Optional, else the value for the 'songs' responseline.
         */
        public Optional<Integer> getSongs() {
            if(isGrouped) {
                return Optional.empty();
            } else {
              return getIntegerValue("songs");
            }
        }
        /**
         * @return if group was not specified, empty Optional, else the value for the 'songs' responseline.
         */
        public Optional<Integer> getPlaytime() {
            if(isGrouped) {
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
         * @return if group not specified, empty list, else groups of response lines as GroupParameter.
         */
        public List<Group> getGroups() {
            if(isGrouped) {
                return getSubResponse(Group.class);
            } else {
                return Collections.emptyList();
            }
        }
    }
}

package musicpd.protocol;

import org.jjflyboy.mpc.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * count command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>MPD Document: The music database.</a>
 * @author jfraney
 */
public class Count extends AbstractCommand<Count.Response> {

    private final musicpd.protocol.Tag group;

    /**
     * a command of form: 'count {TAG} "{NEEDLE}"'.
     * @param tag name of tag to match
     * @param needle value to match
     */
    public Count(Tag tag, String needle) {
        super(new FilterParameter(tag, needle));
        group = null;
    }

    /**
     * a command of form: 'count {TAG} "{NEEDLE}"'.
     * @param tag field name to match
     * @param needle value to match
     * @param group optional value to group results by, null if none.
     */
    public Count(Tag tag, String needle, musicpd.protocol.Tag group) {
        super(new FilterParameter(tag, needle), new GroupParameter(group));
        this.group = group;
    }

    private boolean isGrouped() {
        return group != null;
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
         * @return if group was not specified, empty Optional, else the value for the 'songs' responseline.
         */
        public Optional<Integer> getSongs() {
            if(isGrouped()) {
                return Optional.empty();
            } else {
              return getIntegerValue("songs");
            }
        }
        /**
         * @return if group was not specified, empty Optional, else the value for the 'songs' responseline.
         */
        public Optional<Integer> getPlaytime() {
            if(isGrouped()) {
                return Optional.empty();
            } else {
                return getIntegerValue("playtime");
            }
        }

        public class Group extends ResponseContent {
            /**
             * @param responseLines limited to a single group
             */
            public Group(java.util.List<String> responseLines) {
                super(responseLines);
            }

            public Optional<Integer> getSongs() {
                return getIntegerValue("songs");
            }

            public Optional<Integer> getPlaytime() {
                return getIntegerValue("playtime");
            }

            public Optional<String> getTag(musicpd.protocol.Tag tag) {
                return getStringValue(tag);
            }
        }

        /**
         * @return if group not specified, empty list, else groups of response lines as GroupParameter.
         */
        public List<Group> getGroups() {
            if(isGrouped()) {
                return segments(group)
                        .stream()
                        .map(Group::new)
                        .collect(Collectors.toList());
            } else {
                return Collections.emptyList();
            }
        }
    }

    public static class Builder {
        private final java.util.List<FilterParameter> filters = new ArrayList<>();
        private musicpd.protocol.Tag group;

        public Builder with(Tag tag, String needle) {
            filters.add(new FilterParameter(tag, needle));
            return this;
        }
        public Builder groupBy(musicpd.protocol.Tag group) {
            this.group = group;
            return this;
        }
        private Count build() {
            return new Count(filters, group);
        }
    }
    private Count(java.util.List<FilterParameter> filters, musicpd.protocol.Tag group) {
        super(adapt(new ArrayList<>(filters)), new GroupParameter(group));
        this.group = group;
    }

    public static Count build(Consumer<Builder> builder) {
        Builder b = new Builder();
        builder.accept(b);
        return b.build();
    }
}

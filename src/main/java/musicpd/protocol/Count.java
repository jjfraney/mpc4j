package musicpd.protocol;

import com.github.jjfraney.mpc.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * count command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>
 *     MPD Document: The music database.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class Count extends AbstractCommand<Count.Response> {

    private final musicpd.protocol.Tag group;

    /**
     * a command of form: 'count {TAG} "{NEEDLE}"'.
     * @param tag name of tag to match
     * @param needle value to match
     */
    public Count(final Tag tag, final String needle) {
        super(new FilterParameter(tag, needle));
        group = null;
    }

    /**
     * a command of form: 'count {TAG} "{NEEDLE}"'.
     * @param tag field name to match
     * @param needle value to match
     * @param group optional value to group results by, null if none.
     */
    public Count(final Tag tag, final String needle, final musicpd.protocol.Tag group) {
        super(new FilterParameter(tag, needle), new GroupParameter(group));
        this.group = group;
    }

    private boolean isGrouped() {
        return group != null;
    }

    /**
     * @param responseLines given by mpd server in response to this command.
     * @param connectResponse of the MPD source of the response.
     * @return response to count
     */
    @Override
    public Response response(final List<String> responseLines, final String connectResponse) {
        return new Response(responseLines, connectResponse);
    }

    /**
     * response to count
     */
    public class Response extends HealthResponse {
        Response(final List<String> responseLines, final String connectResponse) {
            super(responseLines, connectResponse);
        }

        /**
         * @return if group was not specified, empty Optional, else the value for the
         * 'songs' response line.
         */
        public Optional<Integer> getSongs() {
            Optional result = Optional.empty();
            if(! isGrouped()) {
              result =  getIntegerValue("songs");
            }
            return result;
        }
        /**
         * @return if group was not specified, empty Optional, else the value for the 'playtime' response line.
         */
        public Optional<Integer> getPlaytime() {
            final Optional result;
            if(! isGrouped()) {
                result = getIntegerValue("playtime");
            } else {
                result = Optional.empty();
            }
            return result;
        }

        public class Group extends ResponseContent {
            /**
             * @param responseLines limited to a single group
             */
            public Group(final List<String> responseLines) {
                super(responseLines);
            }

            public Optional<Integer> getSongs() {
                return getIntegerValue("songs");
            }

            public Optional<Integer> getPlaytime() {
                return getIntegerValue("playtime");
            }

            public Optional<String> getTag(final musicpd.protocol.Tag tag) {
                return getStringValue(tag);
            }
        }

        /**
         * @return if group not specified, empty list, else groups of response lines as GroupParameter.
         */
        public List<Group> getGroups() {
            List<Group> result = Collections.emptyList();
            if(isGrouped()) {
                result = segments(group)
                        .stream()
                        .map(Group::new)
                        .collect(Collectors.toList());
            }
            return result;
        }
    }

    public static class Builder {
        private final List<FilterParameter> filters = new ArrayList<>();
        private musicpd.protocol.Tag group;

        public Builder with(final Tag tag, final String needle) {
            filters.add(new FilterParameter(tag, needle));
            return this;
        }
        public Builder groupBy(final musicpd.protocol.Tag group) {
            this.group = group;
            return this;
        }
        private Count build() {
            return new Count(filters, group);
        }
    }
    private Count(final List<FilterParameter> filters, final musicpd.protocol.Tag group) {
        super(adapt(new ArrayList<>(filters)), new GroupParameter(group));
        this.group = group;
    }

    public static Count build(final Consumer<Builder> builder) {
        final Builder b = new Builder();
        builder.accept(b);
        return b.build();
    }
}

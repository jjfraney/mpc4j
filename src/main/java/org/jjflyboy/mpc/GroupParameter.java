package org.jjflyboy.mpc;

import musicpd.protocol.Tag;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Represents the 'group' parameter for the 'count' and 'list'-ish commands.
 * @author jfraney
 */
public class GroupParameter implements Parameter {
    private final String parameter;
    public GroupParameter(final Tag... tags) {
        this(Arrays.asList(tags));
    }
    public GroupParameter(final java.util.List<Tag> tags) {
        parameter = tags.stream().map(tag -> "group " + tag.toParameter()).collect(Collectors.joining(" "));

    }

    @Override
    public String toParameter() {
        return parameter;
    }
}

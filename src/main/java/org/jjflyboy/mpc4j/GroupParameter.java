package org.jjflyboy.mpc4j;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author jfraney
 */
public class GroupParameter implements Parameter {
    private final String parameter;
    public GroupParameter(Tag ... tags) {
        parameter = Arrays.stream(tags).map(tag -> "group " + tag.toParameter()).collect(Collectors.joining(" "));
    }
    @Override
    public String toParameter() {
        return parameter;
    }
}

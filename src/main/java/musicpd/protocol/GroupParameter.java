package musicpd.protocol;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Represents the 'group' parameter for the 'count' and 'list'-ish commands.
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

package org.jjflyboy.mpc;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class FilterParameter implements Parameter {

    private final String text;
    public FilterParameter(final Parameter type, final String what) {
        this.text = type.toParameter() +
                " \"" +
                what +
                '"';
    }

    @Override
    public String toParameter() {
        return text;
    }
}

package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class Add extends Simple {
    private final String uri;
    public Add(String uri) {
        this.uri = uri;
    }

    @Override
    public String text() {
        return new StringBuilder()
                .append("add")
                .append(" ")
                .append(uri)
                .toString();
    }
}

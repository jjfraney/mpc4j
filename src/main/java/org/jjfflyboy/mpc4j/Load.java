package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class Load extends Simple {
    public Load(String name) {
        super(adapt(name));
    }
    public Load(String name, Integer start, Integer end) {
        super(adapt(name), new RangeParameter(start, end));
    }
}

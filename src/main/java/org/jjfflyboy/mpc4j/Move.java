package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class Move extends Simple {

    public Move(Integer from, Integer to) {
        super(adapt(from), adapt(to));
    }
    public Move(Integer start, Integer end, Integer to) {
        super(new RangeParameter(start, end), adapt(to));
    }
}

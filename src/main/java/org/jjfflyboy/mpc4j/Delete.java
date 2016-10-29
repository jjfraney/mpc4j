package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class Delete extends Simple {

    public Delete(Integer pos) {
        super(adapt(pos));
    }
    public Delete(Integer start, Integer end) {
        super(new RangeParameter(start, end));
    }
}

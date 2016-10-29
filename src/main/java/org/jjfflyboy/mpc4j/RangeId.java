package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class RangeId extends Simple {
    public RangeId(Integer id, Integer start, Integer end) {
        super(adapt(id), new RangeParameter(start, end));
    }
}

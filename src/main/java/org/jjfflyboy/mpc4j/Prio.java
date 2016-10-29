package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class Prio extends Simple {

    public Prio(Integer priority, Integer startPos, Integer endPos) {
        super(adapt(priority), new RangeParameter(startPos, endPos));
    }
}

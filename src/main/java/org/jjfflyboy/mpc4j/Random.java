package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class Random extends Simple {
    final private Toggle toggle;

    public Random(Toggle toggle) {
        this.toggle = toggle;
    }

    @Override
    public String text() {
        return "random " + toggle.encode();
    }
}

package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class Consume extends Simple {
    final private Toggle toggle;

    public Consume(Toggle toggle) {
        this.toggle = toggle;
    }

    @Override
    public String text() {
        return "consume " + toggle.encode();
    }
}

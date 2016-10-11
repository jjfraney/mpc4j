package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class Repeat extends Simple {
    final private Toggle toggle;

    public Repeat(Toggle toggle) {
        this.toggle = toggle;
    }

    @Override
    public String text() {
        return "repeat " + toggle.encode();
    }
}

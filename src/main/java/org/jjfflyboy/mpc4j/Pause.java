package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class Pause extends Simple {
    final private Toggle toggle;

    public Pause(Toggle toggle) {
        this.toggle = toggle;
    }

    @Override
    public String text() {
        return "pause " + toggle.encode();
    }
}

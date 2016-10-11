package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class Single extends Simple {
    final private Toggle toggle;

    public Single(Toggle toggle) {
        this.toggle = toggle;
    }

    @Override
    public String text() {
        return "single " + toggle.encode();
    }
}

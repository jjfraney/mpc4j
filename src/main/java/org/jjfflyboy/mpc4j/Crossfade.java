package org.jjfflyboy.mpc4j;

/**
 * @Author jfraney
 */
public class Crossfade extends Simple {
    final private Integer crossfade;
    public Crossfade(Integer crossfade) {
        this.crossfade = crossfade;
    }
    public Crossfade() {
        this.crossfade = 0;
    }
    @Override
    public String text() {
        return "crossfade " + crossfade.toString();
    }

}

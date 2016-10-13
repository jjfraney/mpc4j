package org.jjfflyboy.mpc4j;

/**
 * @Author jfraney
 */
public class Play extends Simple {
    private final Integer songpos;

    public Play() {
        songpos = null;
    }
    public Play(Integer songpos) {
        this.songpos = songpos;
    }
    @Override
    public String text() {
        return "play" + (songpos == null ? "" : " " + songpos.toString());
    }
}

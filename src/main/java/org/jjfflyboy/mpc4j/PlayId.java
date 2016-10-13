package org.jjfflyboy.mpc4j;

/**
 * @Author jfraney
 */
public class PlayId extends Simple {
    private final Integer songid;

    public PlayId() {
        songid = null;
    }
    public PlayId(Integer songpos) {
        this.songid = songpos;
    }
    @Override
    public String text() {
        return "playid" + (songid == null ? "" : " " + songid.toString());
    }
}

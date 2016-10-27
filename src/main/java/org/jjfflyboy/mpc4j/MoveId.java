package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class MoveId extends Simple {
    private final Integer songId;
    private final Integer to;

    public MoveId(Integer songId, Integer to) {
        this.songId = songId;
        this.to = to;
    }

    @Override
    public String text() {
        return new StringBuilder()
                .append("moveid ")
                .append(songId)
                .append(" ")
                .append(to)
                .toString();
    }
}

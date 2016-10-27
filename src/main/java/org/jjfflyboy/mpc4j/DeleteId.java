package org.jjfflyboy.mpc4j;

import java.util.Optional;

/**
 * @author jfraney
 */
public class DeleteId extends Simple {
    private final Integer songId;
    public DeleteId(Integer songId) {
        this.songId = songId;
    }

    @Override
    public String text() {
        return new StringBuilder()
                .append("deleteid")
                .append(" ")
                .append(songId)
                .toString();
    }
}

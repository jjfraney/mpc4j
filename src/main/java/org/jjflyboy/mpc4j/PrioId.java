package org.jjflyboy.mpc4j;

/**
 * prioid command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * @author jfraney
 */
public class PrioId extends Simple {

    /**
     * @param priority to apply to selected songs
     * @param id of a selected song
     * @param ids of optional, additional songs
     */
    public PrioId(Integer priority, Integer id, Integer ... ids) {
        super(adapt(priority), adapt(id), adapt(ids));
    }
}

package musicpd.protocol;

/**
 * swapid command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * @author jfraney
 */
public class SwapId extends Simple {
    /**
     *
     * @param id1 of one selected song
     * @param id2 of the other selected song
     */
    public SwapId(Integer id1, Integer id2) {
        super(adapt(id1), adapt(id2));
    }
}

package org.jjflyboy.mpc4j;

/**
 * delete command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * @author jfraney
 */
public class Delete extends Simple {

    /**
     * deletes a song from the queue.
     * @param pos the position of the song to delete
     */
    public Delete(Integer pos) {
        super(adapt(pos));
    }

    /**
     * deletes a range of songs from the queue
     * @param start position of first song in range
     * @param end position of last song in the range
     */
    public Delete(Integer start, Integer end) {
        super(new RangeParameter(start, end));
    }
}

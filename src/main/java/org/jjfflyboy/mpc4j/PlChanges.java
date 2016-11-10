package org.jjfflyboy.mpc4j;

/**
 * plchanges command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * <p>
 *     This command's response contains metadata of a queued song.
 * </p>
 * @author jfraney
 */
public class PlChanges extends AbstractCommand<QueuedSongInfoResponse> {
    public PlChanges(Integer version) {
        super(adapt(version));
    }

    @Override
    public QueuedSongInfoResponse response(String[] responseLines) {
        return new QueuedSongInfoResponse(responseLines);
    }
}

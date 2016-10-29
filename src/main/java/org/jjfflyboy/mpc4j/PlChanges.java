package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class PlChanges extends Simple {
    public PlChanges(Integer version) {
        super(adapt(version));
    }

    @Override
    public QueuedSongInfoResponse response(String[] responseLines) {
        return new QueuedSongInfoResponse(responseLines);
    }
}

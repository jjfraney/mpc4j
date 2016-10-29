package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class PlChanges implements Command<QueuedSongInfoResponse> {
    private final Integer version;
    public PlChanges(Integer version) {
        this.version = version;
    }
    @Override
    public String text() {
        return "plchanges " + version;
    }

    @Override
    public QueuedSongInfoResponse response(String[] responseLines) {
        return new QueuedSongInfoResponse(responseLines);
    }
}

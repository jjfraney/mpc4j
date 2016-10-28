package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class PlaylistFind implements Command<QueuedSongInfoResponse> {
    interface Tag extends Filters.Field {
    }
    public static class Filter extends Filters.Filter {
        protected Filter(PlaylistFind.Tag tag, String needle) {
            super(tag, needle);
        }
    }

    private final Filters filters;

    public PlaylistFind(PlaylistFind.Tag tag, String needle) {
        filters = new Filters(new Filter(tag, needle));
    }
    protected Filters getFilters() {
        return filters;
    }
    @Override
    public String text() {
        return "playlistfind " + getFilters().toParameters();
    }

    @Override
    public QueuedSongInfoResponse response(String[] responseLines) {
        return new QueuedSongInfoResponse(responseLines);
    }
}

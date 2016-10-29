package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class PlaylistFind extends Simple {
    interface Tag extends Filters.Field {
    }
    public static class Filter extends Filters.Filter {
        protected Filter(PlaylistFind.Tag tag, String needle) {
            super(tag, needle);
        }
    }

    public PlaylistFind(PlaylistFind.Tag tag, String needle) {
        super(new Filters(new Filter(tag, needle)));
    }

    @Override
    public QueuedSongInfoResponse response(String[] responseLines) {
        return new QueuedSongInfoResponse(responseLines);
    }
}

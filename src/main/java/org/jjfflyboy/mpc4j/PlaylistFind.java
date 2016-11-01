package org.jjfflyboy.mpc4j;

/**
 * playlistfind command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * <p>
 *     This command's response contains metadata of a queued song.
 * </p>
 * @author jfraney
 */
public class PlaylistFind extends AbstractCommand<QueuedSongInfoResponse> {
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

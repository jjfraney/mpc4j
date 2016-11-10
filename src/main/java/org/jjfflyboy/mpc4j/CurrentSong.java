package org.jjfflyboy.mpc4j;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * currentsong command
 * from <a href='https://www.musicpd.org/doc/protocol/command_reference.html#status_commands'>MPD document</a>
 * @Author jfraney
 */

public class CurrentSong extends AbstractCommand<QueuedSongInfoResponse> {

    public CurrentSong() {
        super();
    }

    /**
     * @param responseLines given by mpd server in response to this command.
     * @return response to 'currentsong' command
     */
    @Override
    public QueuedSongInfoResponse response(String[] responseLines) {
        return new QueuedSongInfoResponse(responseLines);
    }
}

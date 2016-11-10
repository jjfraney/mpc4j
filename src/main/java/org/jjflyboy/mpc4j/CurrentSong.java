package org.jjflyboy.mpc4j;

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
    public QueuedSongInfoResponse response(java.util.List<String> responseLines) {
        return new QueuedSongInfoResponse(responseLines);
    }
}

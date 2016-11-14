package musicpd.protocol;

import org.jjflyboy.mpc.QueueQuery;

/**
 * currentsong command
 * from <a href='https://www.musicpd.org/doc/protocol/command_reference.html#status_commands'>MPD document</a>
 * @Author jfraney
 */

public class CurrentSong extends QueueQuery {

    public CurrentSong() {
        super();
    }
}

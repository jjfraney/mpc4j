package musicpd.protocol;

import org.jjflyboy.mpc.AbstractCommand;
import org.jjflyboy.mpc.Command;

import java.util.List;

/**
 * sticker command from
 * <a href='https://www.musicpd.org/doc/protocol/stickers.html'>MPD Document: Stickers.</a>
 * <p>
 *     My implementation of mpd does not support stickers.
 *     Then, the MPD developer says this command is
 *     <a href="https://forum.musicpd.org/viewtopic.php?f=11&t=3964&p=6104&hilit=stickers#p6104">only for songs.</a>
 *     and there are no plans to extend it.
 *     Therefore, this command is intentionally disabled.
 *     It is left here as a placeholder to document this decision.
 * </p>
 * @author jfraney
 */
public class Sticker extends AbstractCommand<Command.Response> {

    /**
     * No implementation is provided.
     */
    private Sticker() {
        throw new RuntimeException("Do not use.");
    }

    @Override
    public String text() {
        throw new RuntimeException("Do not use.");
    }

    @Override
    public Response response(List<String> responseLines, String connectResponse) {
        return null;
    }
}

package musicpd.protocol;

import com.github.jjfraney.mpc.AbstractCommand;
import com.github.jjfraney.mpc.Command;
import com.github.jjfraney.mpc.MpcRuntimeException;

import java.util.List;

/**
 * sticker command from
 * <a href='https://www.musicpd.org/doc/protocol/stickers.html'>
 *     MPD Document: Stickers.</a>
 * <p>
 *     My implementation of mpd does not support stickers.
 *     Then, the MPD developer says this command is
 *     <a href="https://forum.musicpd.org/viewtopic.php?f=11&t=3964&p=6104&hilit=stickers#p6104">
 *         only for songs.</a>
 *     and there are no plans to extend it.
 *     Therefore, this command is intentionally disabled.
 *     It is left here as a placeholder to document this decision.
 * </p>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class Sticker extends AbstractCommand<Command.Response> {

    /**
     * No implementation is provided.
     */
    private Sticker() {
        throw new MpcRuntimeException("Do not use.");
    }

    @Override
    public String text() {
        throw new MpcRuntimeException("Do not use.");
    }

    @Override
    public Response response(final List<String> responseLines, final String connectResponse) {
        return null;
    }
}

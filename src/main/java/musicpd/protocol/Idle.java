package musicpd.protocol;

import org.jjflyboy.mpc.AbstractCommand;
import org.jjflyboy.mpc.HealthResponse;
import org.jjflyboy.mpc.Parameter;

import java.util.Optional;

/**
 * idle command
 * from
 * <a href='https://www.musicpd.org/doc/protocol/command_reference.html#status_commands'>
 *     MPD document</a>
 * @author jfraney
 */
public class Idle extends AbstractCommand<Idle.Response> {
    /**
     * valid subsystems for the idle command
     */
    public enum Subsystem implements Parameter {
        DATABASE, UPDATE, STORED_PLAYLIST, PLAYLIST, PLAYER, MIXER, OUTPUT, OPTIONS, STICKER, SUBSCRIPTION, MESSAGE;

        public static Subsystem decode(final String v) {
            return valueOf(v.toUpperCase());
        }
        public String encode() {
            return name().toLowerCase();
        }

        @Override
        public String toParameter() {return encode();}
    }

    /**
     * @param subsystems list of subsystems of interest; if empty: all subsystems.
     */
    public Idle(final Subsystem ... subsystems) {
        super((Parameter[]) subsystems);
    }

    /**
     * @param responseLines given by mpd server in response to this command.
     * @return response to 'idle' command
     */
    @Override
    public Response response(final java.util.List<String> responseLines, final String connectResponse) {
        return new Response(responseLines, connectResponse);
    }


    /**
     * provides access to the the values in an 'idle' response.
     */
    public static class Response extends HealthResponse {

        /**
         * @return subsystem of 'changed: ' line
         */
        public Optional<Subsystem> getChanged() {
            return getStringValue("changed").map(Subsystem::decode);
        }
        Response(final java.util.List<String> responseLines, final String connectResponse) {
            super(responseLines, connectResponse);
        }
    }
}

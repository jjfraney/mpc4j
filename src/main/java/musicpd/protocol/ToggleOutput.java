package musicpd.protocol;

/**
 * toggleoutput command from
 * <a href='https://www.musicpd.org/doc/protocol/output_commands.html'>
 *     MPD Document: Audio output devices.</a>
 * @author jfraney
 */
public class ToggleOutput extends Simple {
    /**
     * @param id of output device
     */
    public ToggleOutput(final Integer id) {
        super(adapt(id));
    }
}

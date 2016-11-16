package musicpd.protocol;

/**
 * disableoutput command from
 * <a href='https://www.musicpd.org/doc/protocol/output_commands.html'>
 *     MPD Document: Audio output devices.</a>
 * @author jfraney
 */
public class DisableOutput extends Simple {
    /**
     * @param id of output device
     */
    public DisableOutput(final Integer id) {
        super(adapt(id));
    }
}

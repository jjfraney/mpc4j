package musicpd.protocol;

/**
 * disableoutput command from
 * <a href='https://www.musicpd.org/doc/protocol/output_commands.html'>MPD Document: Audio output devices.</a>
 * @Author jfraney
 */
public class DisableOutput extends Simple {
    /**
     * @param id of output device
     */
    public DisableOutput(Integer id) {
        super(adapt(id));
    }
}

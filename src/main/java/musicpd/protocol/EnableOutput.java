package musicpd.protocol;

/**
 * enableoutput command from
 * <a href='https://www.musicpd.org/doc/protocol/output_commands.html'>
 *     MPD Document: Audio output devices.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class EnableOutput extends Simple {
    /**
     * @param id of output device
     */
    public EnableOutput(final Integer id) {
        super(adapt(id));
    }
}

package musicpd.protocol;

/**
 * close command from
 * <a href='https://www.musicpd.org/doc/protocol/connection_commands.html'>
 *     MPD Document: The Connection settings.</a>
 * <p>
 *     The close command's response has no content.
 * </p>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class Close extends Simple {
    public Close() {
        super();
    }
}

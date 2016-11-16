package musicpd.protocol;

/**
 * password command from
 * <a href='https://www.musicpd.org/doc/protocol/connection_commands.html'>
 *     MPD Document: The Connection settings.</a>
 * @author jfraney
 */
public class Password extends Simple {
    /**
     * @param password to authenticate
     */
    public Password(final String password) {
        super(adapt(password));
    }
}

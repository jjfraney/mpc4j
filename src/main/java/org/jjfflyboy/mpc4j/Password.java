package org.jjfflyboy.mpc4j;

/**
 * password command from
 * <a href='https://www.musicpd.org/doc/protocol/connection_commands.html'>MPD Document: The Connection settings.</a>
 */
public class Password extends Simple {
    /**
     * @param password
     */
    public Password(String password) {
        super(adapt(password));
    }
}

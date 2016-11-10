package org.jjflyboy.mpc4j;

/**
 * clearerror command
 * from <a href='https://www.musicpd.org/doc/protocol/command_reference.html#status_commands'>MPD document</a>
 * <p>
 *     This command has a simple response, 'OK' or 'ACK...'
 * </p>
 * @Author jfraney
 */
public class ClearError extends Simple {
    public ClearError() {
        super();
    }
}

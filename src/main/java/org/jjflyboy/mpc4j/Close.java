package org.jjflyboy.mpc4j;

/**
 * close command from
 * <a href='https://www.musicpd.org/doc/protocol/connection_commands.html'>MPD Document: The Connection settings.</a>
 * <p>
 *     The close command's response has no content.
 * </p>
 * @author jfraney
 */
public class Close extends Simple {
    public Close() {
        super();
    }
}

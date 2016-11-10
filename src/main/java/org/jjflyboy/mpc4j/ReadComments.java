package org.jjflyboy.mpc4j;

/**
 * readcomments command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>MPD Document: The music database.</a>
 * <p>
 *     On this command, mpd returns a list of arbitrary name-values.
 *     Use Response.getResponseLines() to access them.
 * </p>
 * @author jfraney
 */
public class ReadComments extends Simple {
    /**
     * @param uri of song
     */
    public ReadComments(String uri) {
        super(adapt(uri));
    }

}

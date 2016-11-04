package org.jjfflyboy.mpc4j;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

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

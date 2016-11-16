package org.jjflyboy.mpc;

/**
 * Class to access the last line of every mpd response..
 * @author jfraney
 */
public final class SimpleResponse extends HealthResponse {

    public SimpleResponse(final java.util.List<String> responseLines, final String connectResponse) {
        super(responseLines, connectResponse);
    }
}

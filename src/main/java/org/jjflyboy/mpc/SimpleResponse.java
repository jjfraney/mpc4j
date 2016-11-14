package org.jjflyboy.mpc;

/**
 * Class to access the last line of every mpd response..
 * @author jfraney
 */
public final class SimpleResponse extends HealthResponse {

    public SimpleResponse(java.util.List<String> responseLines, String connectResponse) {
        super(responseLines, connectResponse);
    }
}

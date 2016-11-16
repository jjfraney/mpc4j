package com.github.jjfraney.mpc;

/**
 * Class to access the last line of every mpd response..
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public final class SimpleResponse extends HealthResponse {

    public SimpleResponse(final java.util.List<String> responseLines, final String connectResponse) {
        super(responseLines, connectResponse);
    }
}

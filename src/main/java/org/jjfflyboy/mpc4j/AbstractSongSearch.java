package org.jjfflyboy.mpc4j;

/**
 * Common response for accessing the song database
 * @author jfraney
 */
public abstract class AbstractSongSearch implements Command<SongSearchResponse> {


    @Override
    public SongSearchResponse response(String[] responseLines) {
        return new SongSearchResponse(responseLines);
    }

}

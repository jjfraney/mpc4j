package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class PlaylistSearch extends PlaylistFind {

    public PlaylistSearch(PlaylistSearch.Tag tag, String needle) {
        super(tag, needle);
    }
    @Override
    public String text() {
        return "playlistsearch " + getFilters().toParameters();
    }
}

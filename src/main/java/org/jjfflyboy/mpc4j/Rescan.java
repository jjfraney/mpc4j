package org.jjfflyboy.mpc4j;

/**
 * rescan command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>MPD Document: The music database.</a>
 * @Author jfraney
 */
public class Rescan extends Simple {
    public Rescan() {
        super();
    }
    public Rescan(String uri) {
        super(adapt(uri));
    }
}

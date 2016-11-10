package org.jjflyboy.mpc4j;

/**
 * update command from
 * <a href='https://www.musicpd.org/doc/protocol/database.html'>MPD Document: The music database.</a>
 * @Author jfraney
 */
public class Update extends Simple {
    public Update() {
        super();
    }
    public Update(String uri) {
        super(adapt(uri));
    }
}

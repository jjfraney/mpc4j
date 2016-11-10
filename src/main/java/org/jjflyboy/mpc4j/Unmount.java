package org.jjflyboy.mpc4j;

/**
 * unmount command from
 * <a href='https://www.musicpd.org/doc/protocol/mount.html'>MPD Document: Mounts and neighbors.</a>
 * @author jfraney
 */
public class Unmount extends Simple {
    /**
     * @param path to unmount
     */
    public Unmount(String path) {
        super(adapt(path));
    }
}

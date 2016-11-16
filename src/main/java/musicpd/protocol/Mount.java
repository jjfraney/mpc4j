package musicpd.protocol;

/**
 * mount command from
 * <a href='https://www.musicpd.org/doc/protocol/mount.html'>
 *     MPD Document: Mounts and neighbors.</a>
 * @author jfraney
 */
public class Mount extends Simple {
    /**
     * @param path of mount point
     * @param uri of remote storage
     */
    public Mount(final String path, final String uri) {
        super(adapt(path), adapt(uri));
    }
}

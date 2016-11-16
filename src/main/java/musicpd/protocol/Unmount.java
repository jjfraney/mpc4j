package musicpd.protocol;

/**
 * unmount command from
 * <a href='https://www.musicpd.org/doc/protocol/mount.html'>
 *     MPD Document: Mounts and neighbors.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class Unmount extends Simple {
    /**
     * @param path to unmount
     */
    public Unmount(final String path) {
        super(adapt(path));
    }
}

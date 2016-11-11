package musicpd.protocol;

/**
 * add command from
 * <a href='https://www.musicpd.org/doc/protocol/queue.html'>MPD Document: The current playlist.</a>
 * @author jfraney
 */
public class Add extends Simple {
    /**
     * @param uri song file location
     */
    public Add(String uri) {
        super(adapt(uri));
    }
}

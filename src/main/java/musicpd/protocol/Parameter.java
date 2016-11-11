package musicpd.protocol;

/**
 * @author jfraney
 */
public interface Parameter {
    /**
     * @return the parameter with the mpd protocol spelling
     */
    String toParameter();
}

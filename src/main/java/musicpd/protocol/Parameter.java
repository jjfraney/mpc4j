package musicpd.protocol;

/**
 * @author jfraney
 */
interface Parameter {
    /**
     * @return the parameter with the mpd protocol spelling
     */
    String toParameter();
}

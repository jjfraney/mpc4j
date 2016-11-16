package musicpd.protocol;

/**
 * setvol command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_option_commands.html'>
 *     MPD Playback option commands.</a>
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class SetVol extends Simple {
    /**
     * @param volume level 0-100
     */
    public SetVol(final Integer volume) {
        super(adapt(volume));
    }
}

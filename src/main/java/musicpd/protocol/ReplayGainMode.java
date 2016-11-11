package musicpd.protocol;

/**
 * replay_gain_mode command from
 * <a href='https://www.musicpd.org/doc/protocol/playback_option_commands.html'>MPD Playback option commands.</a>
 * @author jfraney
 */
public class ReplayGainMode extends Simple {
    /**
     * set of 'replay gain modes' available
     */
    public enum Mode implements Parameter {
        OFF, TRACK, ALBUM, AUTO;
        public static Mode decode(String value) {
            return valueOf(value.toUpperCase());
        }
        public String encode() {
            return name().toLowerCase();
        }
        public String toString() {return encode();}

        @Override
        public String toParameter() {
            return encode();
        }
    }

    @Override
    protected String command() {
        return "replay_gain_mode";
    }

    /**
     * @param mode to apply
     */
    public ReplayGainMode(Mode mode) {
        super(mode);
    }
}

package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class ReplayGainMode extends Simple {
    // I don't like the name "ReplayGainMode.Mode"....just following the protocol here.
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
    public ReplayGainMode(Mode mode) {
        super(mode);
    }
}

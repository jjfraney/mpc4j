package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public class ReplayGainMode extends Simple {
    // I don't like the name "ReplayGainMode.Mode"....just following the protocol here.
    public enum Mode {
        OFF, TRACK, ALBUM, AUTO;
        public static Mode decode(String value) {
            return valueOf(value.toUpperCase());
        }
        public String encode() {
            return name().toLowerCase();
        }
    }
    final private Mode mode;

    public ReplayGainMode(Mode mode) {
        this.mode = mode;
    }

    @Override
    public String text() {
        return "replay_gain_mode " + mode.encode();
    }
}

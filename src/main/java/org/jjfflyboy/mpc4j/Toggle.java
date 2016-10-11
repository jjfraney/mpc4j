package org.jjfflyboy.mpc4j;

/**
 * @author jfraney
 */
public enum Toggle {
    ON("1"), OFF("0");

    final private String code;
    Toggle(String code) {
        this.code = code;
    }
    public static Toggle decode(String code) {
        if(OFF.code.equals(code)) {
            return OFF;
        } else if(ON.code.equals(code)) {
            return ON;
        } else {
            throw new RuntimeException("Unknown value: " + code);
        }
    }
    public String encode() {
        return code;
    }
}

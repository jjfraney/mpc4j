package org.jjflyboy.mpc;

/**
 * @author jfraney
 */
public class MpcRuntimeException extends RuntimeException {
    public MpcRuntimeException() {
    }

    public MpcRuntimeException(final String s) {
        super(s);
    }

    public MpcRuntimeException(final String s, final Throwable throwable) {
        super(s, throwable);
    }

    public MpcRuntimeException(final Throwable throwable) {
        super(throwable);
    }

    public MpcRuntimeException(final String s, final Throwable throwable, final boolean b, final boolean b1) {
        super(s, throwable, b, b1);
    }
}

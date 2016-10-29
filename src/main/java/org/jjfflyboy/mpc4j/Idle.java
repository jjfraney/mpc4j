package org.jjfflyboy.mpc4j;

import java.util.Optional;

/**
 * @Author jfraney
 */
public class Idle extends AbstractCommand<Idle.Response> {
    public enum Subsystem implements Parameter {
        DATABASE, UPDATE, STORED_PLAYLIST, PLAYLIST, PLAYER, MIXER, OUTPUT, OPTIONS, STICKER, SUBSCRIPTION, MESSAGE;

        public static Subsystem decode(String v) {
            return valueOf(v.toUpperCase());
        }
        public String encode() {
            return name().toLowerCase();
        }

        @Override
        public String toParameter() {return encode();}
    }

    public Idle(Subsystem ... subsystems) {
        super(subsystems);
    }

    @Override
    public Response response(String [] responseLines) {
        return new Response(responseLines);
    }


    public static class Response extends SimpleResponse {

        public Optional<Subsystem> getChanged() {
            return getStringValue("changed").map(s->Subsystem.decode(s));
        }
        Response(String[] responseLines) {
            super(responseLines);
        }
    }
}

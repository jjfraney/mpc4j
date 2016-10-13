package org.jjfflyboy.mpc4j;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author jfraney
 */
public class Idle implements Command<Idle.Response> {
    public enum Subsystem {
        DATABASE, UPDATE, STORED_PLAYLIST, PLAYLIST, PLAYER, MIXER, OUTPUT, OPTIONS, STICKER, SUBSCRIPTION, MESSAGE;

        public static Subsystem decode(String v) {
            return valueOf(v.toUpperCase());
        }
        public String encode() {
            return name().toLowerCase();
        }
    }

    private final Subsystem[] subsystems;
    public Idle(Subsystem ... subsystems) {
        this.subsystems = subsystems;
    }

    @Override
    public String text() {
        String args = Stream.of(subsystems).map(s -> s.encode()).collect(Collectors.joining(" "));
        if(args.length() > 0) {
            return "idle " + args;
        } else {
            return "idle";
        }
    }

    @Override
    public Response response(String [] responseLines) {
        return new Response(responseLines);
    }


    public static class Response extends AbstractContentResponse {

        public Optional<Subsystem> getChanged() {
            return getStringValue("changed").map(s->Subsystem.decode(s));
        }
        Response(String[] responseLines) {
            super(responseLines);
        }
    }
}

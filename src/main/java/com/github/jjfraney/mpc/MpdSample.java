package com.github.jjfraney.mpc;

import musicpd.protocol.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.stream.Stream;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class MpdSample {
    private static MPC mpc = new MPC();

    public static void main(final String [] args) throws IOException {


        //sendIdle();

        runStatusQueryCommands();

        run(new Ping());
        run(new Update());

        runPlaybackOptions();

        runPlaybackControlCommands();


        final Status.Response r = mpc.send(new Status());

        System.out.println("volume=" + r.getVolume().orElse(-1));
        System.out.println("mix ramp db: " + r.getMixRampDb().orElse(null));
        System.out.println("error=" + r.getError().orElse("no error"));

        //mpc.idle(e -> { Stream.of(e).forEach(System.out::println); return true; });
    }

    private static void runPlaybackControlCommands() throws IOException {
        run(new Play());
        run(new Pause(Toggle.ON));
        run(new Pause(Toggle.OFF));
        run(new Stop());
        run(new Next());
        run(new Previous());
        run(new Seek(0, 2.2f));
        run(new Stop());
    }

    private static void runPlaybackOptions() throws IOException {
        run(new Consume(Toggle.ON));
        run(new Consume(Toggle.OFF));
        run(new Crossfade(3));
        run(new MixRampDelay(20));
        run(new MixRampDelay());
        run(new MixRampDB(new BigDecimal("-17.1")));
        run(new Random(Toggle.OFF));

        run(new Repeat(Toggle.ON));
        run(new Repeat(Toggle.OFF));
        run(new SetVol(30));
        run(new Single(Toggle.ON));
        run(new Single(Toggle.OFF));
        run(new ReplayGainMode(ReplayGainMode.Mode.AUTO));
        run(new ReplayGainStatus());
        run(new ReplayGainMode(ReplayGainMode.Mode.OFF));
    }

    private static void runStatusQueryCommands() throws IOException {
        run(new ClearError());
        run(new CurrentSong());
        final QueueQueryResponse csr = mpc.send(new CurrentSong());
        final QueueQueryResponse.QueuedSongMetadata info =  csr.getSongMetadata().get(0);
        System.out.println("last modified: " + info.getLastModified());
        run(new Status());
        run(new Stats());
    }

    private static void sendIdle() throws IOException {
        final Idle.Response ir = mpc.send(new Idle(Idle.Subsystem.OPTIONS, Idle.Subsystem.MIXER));
        System.out.println("what changed? " + ir.getChanged().orElse(null));
    }

    private static void run(final Command command) throws IOException {
        final Command.Response response = mpc.send(command);
        System.out.println("command: '" + command.text() + "' isOk? ...." + response.isOk());
        Stream.of(response.getResponseLines()).map(s -> "\t" + s).forEach(System.out::println);
    }
}

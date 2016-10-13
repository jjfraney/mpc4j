package org.jjfflyboy.mpc4j;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.jjfflyboy.mpc4j.Toggle.OFF;
import static org.jjfflyboy.mpc4j.Toggle.ON;

/**
 * @author jfraney
 */
public class MpdSample {
    private static MPC mpc = new MPC();

    public static void main(String [] args) throws IOException {


        //sendIdle();

        runStatusQueryCommands();

        run(new Ping());
        run(new Update());

        run(new Crossfade(3));
        run(new MixRampDelay(20));
        run(new MixRampDelay());
        run(new MixRampDB(new BigDecimal("-17.1")));
        run(new Random(OFF));

        run(new Repeat(ON));
        run(new Repeat(OFF));
        run(new SetVol(30));
        run(new Single(ON));
        run(new Single(OFF));
        run(new ReplayGainMode(ReplayGainMode.Mode.AUTO));
        run(new ReplayGainStatus());
        run(new ReplayGainMode(ReplayGainMode.Mode.OFF));


        Status.Response r = mpc.send(new Status());

        System.out.println("volume=" + r.getVolume().orElse(-1));
        System.out.println("mix ramp db: " + r.getMixRampDb().orElse(null));
        System.out.println("error=" + r.getError().orElse("no error"));

        //mpc.idle(e -> { Stream.of(e).forEach(System.out::println); return true; });

        //run(new Update());
    }

    private static void runStatusQueryCommands() throws IOException {
        run(new ClearError());
        run(new CurrentSong());
        CurrentSong.Response csr = mpc.send(new CurrentSong());
        System.out.println("last modified: " + csr.getLastModified());
        run(new Status());
        run(new Stats());
    }

    private static void sendIdle() throws IOException {
        Idle.Response ir = mpc.send(new Idle(Idle.Subsystem.OPTIONS, Idle.Subsystem.MIXER));
        System.out.println("what changed? " + ir.getChanged().get());
    }

    private static Command.Response run(Command command) throws IOException {
        Command.Response response = mpc.send(command);
        System.out.println(command.getClass().getSimpleName() + " isOk? ...." + response.isOk());
        Stream.of(response.getResponseLines()).forEach(System.out::println);
        return response;
    }
}

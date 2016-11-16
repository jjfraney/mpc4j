package musicpd.protocol;

import org.jjflyboy.mpc.AbstractCommand;
import org.jjflyboy.mpc.HealthResponse;
import org.jjflyboy.mpc.ResponseContent;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * outputs command from
 * <a href='https://www.musicpd.org/doc/protocol/output_commands.html'>
 *     MPD Document: Audio output devices.</a>
 * <p>
 *     On this command, mpd returns a list of outputs.
 * </p>
 * @author jfraney
 */
public class Outputs extends AbstractCommand<Outputs.Response> {

    @Override
    public Response response(final java.util.List<String> responseLines, final String connectResponse) {
        return new Response(responseLines, connectResponse);
    }

    public static class Response extends HealthResponse {
        Response(final java.util.List<String> responseLines, final String connectResponse) {
            super(responseLines, connectResponse);
        }

        public class Output extends ResponseContent {
            Output(final java.util.List<String> responseLines) {
                super(responseLines);
            }

            /**
             * @return value of outputid label
             */
            public Optional<Integer> getOutputId() {return getIntegerValue("outputid");}
            /**
             * @return value of outputname label
             */
            public Optional<String> getOutputName() {return getStringValue("outputname");}

            public Optional<Integer> getOutputEnabled() {return getIntegerValue("outputenabled");}
        }
        /**
         * access the response to get the neighbors from the response.
         * @return a list of neighbors.
         */
        public java.util.List<Output> getOutputs() {
            return segments("outputid").stream()
                    .map(Output::new)
                    .collect(Collectors.toList());
        }
    }
}

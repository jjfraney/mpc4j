package musicpd.protocol;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * outputs command from
 * <a href='https://www.musicpd.org/doc/protocol/output_commands.html'>MPD Document: Audio output devices.</a>
 * <p>
 *     On this command, mpd returns a list of outputs.
 * </p>
 * @author jfraney
 */
public class Outputs extends AbstractCommand<Outputs.Response> {
    public Outputs() {
        super();
    }

    @Override
    public Response response(java.util.List<String> responseLines) {
        return new Response(responseLines);
    }

    public static class Response extends HealthResponse {
        Response(java.util.List<String> responseLines) {
            super(responseLines);
        }

        public class Output extends ResponseContent {
            Output(java.util.List<String> responseLines) {
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
                    .map(sg -> new Output(sg))
                    .collect(Collectors.toList());
        }
    }
}

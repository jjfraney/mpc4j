package musicpd.protocol;

import org.jjflyboy.mpc.Command;
import org.jjflyboy.mpc.HealthResponse;
import org.jjflyboy.mpc.ResponseContentParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * implements MPD protocol's
 * <a href='https://www.musicpd.org/doc/protocol/command_lists.html'>
 *     aggregation of commands.</a>
 * <p>
 *     We use 'command_list_ok_begin' because it puts 'list_OK'
 *     separator in response.
 * </p>
 * @author jfraney
 * @see ResponseContentParser
 */
public class CommandList implements Command<CommandList.Response> {

    private final List<Command> commands;

    /**
     * @param commands to send as a commandlist
     */
    public CommandList(final Command ... commands) {
        this.commands = Collections.unmodifiableList(Arrays.asList(commands));
    }

    /**
     * @return commandlist text
     */
    @Override
    public String text() {
        final String list =  commands.stream()
                .map(Command::text)
                .collect(Collectors.joining("\n"));
        return "command_list_ok_begin\n" +
                list +
                "\ncommand_list_end";
    }

    /**
     *
     * @param responseLines given by mpd server in response to this command.
     * @param connectResponse of the MPD source of the response.
     * @return response to commandlist
     */
    @Override
    public Response response(final List<String> responseLines, final String connectResponse) {
        return new Response(responseLines, connectResponse, commands);
    }

    /**
     * command list response to access response to each of the commands
     */
    public static class Response extends HealthResponse {
        private final List<Command> commands;
        public Response(final List<String> responseLines, final String connectResponse, final List<Command> commands) {
            super(responseLines, connectResponse);
            this.commands = commands;
        }

        /**
         * Separate the response of each command.
         * <p>
         *     The return of this method is not defined if
         *     the 'command list' response is not ok.
         * </p>
         * <p>
         *     Many commands' response have no content.
         *     They contain only one line, either 'OK' or 'ACK ...'.
         *     Example of these are 'random' or 'play'.
         *     Some commands' response do have content, like 'status' or 'find ...'.
         *     This command list can have a mix of these.
         *     <ul>
         *         <li>
         *             If all commands in this command list have no response,
         *             then there is no reason to use this method.
         *         </li>
         *         <li>
         *             If one or more commands in this command list have a response,
         *             then this method can access each response.
         *             The caller must cast an element to the expected response.
         *             For example:
         *             <pre>
         *{@code
         *
         * List<Command.Response> responses = listResponse.getResponses();
         *
         * int i = ...;  // knowing that the i-th command is a 'status' command
         *
         * // instanceof check omitted for clarity.
         * Status.Response statusResponse = (Status.Response)(responses.get(i));
         * }
         *             </pre>
         *         </li>
         *     </ul>
         * </p>
         * @return individual responses per command
         */
        public List<Command.Response> getResponses() {
            final List<List<String>> responses = segments();

            final List<Command.Response> result = new ArrayList<>();
            for(int i = 0; i < responses.size(); i++ ) {
                result.add(commands.get(i).response(responses.get(i), getConnectResponse()));
            }
            return result;
        }

        /**
         * separate segments by the line 'list_OK'.
         * <p>
         *     This algorithm is much like {@link ResponseContentParser#segments(List, String...)}.
         *     Here, the marker is at the END of the segment, not the beginning.
         * </p>
         * @return list of segments (i.e., list of lines), each ending with 'list_OK'
         */
        private List<List<String>> segments() {
            final List<List<String>> result = new ArrayList<>();
            List<String> segment = new ArrayList<>();
            for(final String line: getResponseLines()) {
                if(line.startsWith("OK") || line.startsWith("ACK")) {
                    continue;
                }

                segment.add(line);

                if("list_OK".equals(line)) {
                    result.add(Collections.unmodifiableList(segment));
                    segment = new ArrayList<>();
                }
            }
            return Collections.unmodifiableList(result);
        }

    }
}

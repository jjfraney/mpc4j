package musicpd.protocol;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * implements MPD protocol's
 * <a href='https://www.musicpd.org/doc/protocol/command_lists.html'>aggregation of commands.</a>
 * <p>
 *     We use 'command_list_ok_begin' because it puts 'list_OK' separator in response.
 * </p>
 * @author jfraney
 * @see ResponseContentParser
 */
public class CommandList extends AbstractCommand<CommandList.Response> {

    private final List<Command> commands;
    public CommandList(Command ... commands) {
        this.commands = Collections.unmodifiableList(Arrays.asList(commands));
    }
    @Override
    public String text() {
        String list =  commands.stream()
                .map(Command::text)
                .collect(Collectors.joining("\n"));
        return new StringBuilder()
                .append("command_list_ok_begin\n")
                .append(list)
                .append("\ncommand_list_end")
                .toString();
    }

    @Override
    public Response response(List<String> responseLines) {
        return new Response(responseLines, commands);
    }

    public static class Response extends HealthResponse {
        private final List<Command> commands;
        public Response(List<String> responseLines, List<Command> commands) {
            super(responseLines);
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
            List<List<String>> responses = segments();

            List<Command.Response> result = new ArrayList<>();
            for(int i = 0; i < responses.size(); i++ ) {
                result.add(commands.get(i).response(responses.get(i)));
            }
            return result;
        }

        /**
         * separate segments by the line 'list_OK'.
         * <p>
         *     This algorithm is much like {@link ResponseContentParser#segments(List, String...)}.
         *     Here, the marker is at the END of the segment, not the beginning.
         * </p>
         * @return
         */
        private List<List<String>> segments() {
            List<List<String>> result = new ArrayList<>();
            List<String> segment = new ArrayList();
            for(String line: getResponseLines()) {
                if(line.startsWith("OK") || line.startsWith("ACK")) {
                    continue;
                }

                segment.add(line);

                if(line.equals("list_OK")) {
                    result.add(Collections.unmodifiableList(segment));
                    segment = new ArrayList<>();
                }
            }
            return Collections.unmodifiableList(result);
        }

    }
}

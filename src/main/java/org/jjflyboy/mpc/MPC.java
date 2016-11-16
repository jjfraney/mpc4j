package org.jjflyboy.mpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class MPC {
    private String host = "localhost";
    private int port = 6600;

    public MPC() {
    }
    public MPC(final String host, final int port) {
        this.host = host;
        this.port = port;
    }

    public void idle(final Function<String [], Boolean> callback) throws IOException {
        final SocketAddress address = new InetSocketAddress(host, port);
        try (SocketChannel channel = SocketChannel.open()) {

            channel.connect(address);

            final BufferedReader fromMpd = new BufferedReader(Channels.newReader(channel, "UTF-8"));

            String connectResponse;
            // first, expect the connect status
            while ((connectResponse = fromMpd.readLine()) != null) {
                if (responseComplete(connectResponse)) {
                    break;
                }
            }

            // then read response into a List
            String [] event;
            do {
                final ByteBuffer outGoing = ByteBuffer.wrap("idle\n".getBytes(UTF_8));
                channel.write(outGoing);

                final List<String> lines = new ArrayList<>();
                String responseSegment;
                while ((responseSegment = fromMpd.readLine()) != null) {
                    lines.add(responseSegment);
                    if (responseComplete(responseSegment)) {
                        break;
                    }
                }
                event = lines.toArray(new String[lines.size()]);
            } while (callback.apply(event)) ;
        }
    }

    @SuppressWarnings("unchecked")
    public <R extends Command.Response> R send(final Command command) throws IOException {
        final List<String> result;
        String connectResponse;

        // try-with-resource: opens socket, a a writer toMpd, and a reader fromMpd
        final SocketAddress address = new InetSocketAddress(host, port);
        try (SocketChannel channel = SocketChannel.open()) {

            channel.connect(address);

            final BufferedReader fromMpd = new BufferedReader(Channels.newReader(channel, UTF_8.newDecoder(), -1));

            // first, expect the connect status
            while ((connectResponse = fromMpd.readLine()) != null) {
                if (responseComplete(connectResponse)) {
                    break;
                }
            }

            // now send the command as text
            final ByteBuffer outGoing = ByteBuffer.wrap((command.text() + "\n").getBytes(UTF_8));
            channel.write(outGoing);

            // then read response into a List
            final List<String> lines = new ArrayList<>();
            String responseSegment;
            while ((responseSegment = fromMpd.readLine()) != null) {
                lines.add(responseSegment);
                if (responseComplete(responseSegment)) {
                    break;
                }
            }

            result = lines;
        }
        return (R) command.response(result, connectResponse);
    }

    private static boolean responseComplete(final String response) {
        return response.startsWith("OK") || response.startsWith("ACK");
    }
}

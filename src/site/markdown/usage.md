
#Invoking Commands

```java
    // to set volume to 10%
    final SetVol setVol = new SetVol(10);
    final Simple.Response setVolResponse = .....send(setVol);
    final boolean success = setVolResponse.isOk();
    
    final Status status = new Status();
    final Status.Response statusResponse = ....send(status);
    final Integer volume = statusResponse.getVolume().orElseThrow(RuntimeException::new);

```

# Sending Commands and Receiving Responses

The developer using this library would provide an implementation to
send the command and receive the request.
Such an implementation, perhaps a method named ```send```,
would be implemented to use the Command and Response this way:

```java
/**
 * A sample MPC implementation.
 */
class MPC {
    /**
     * use a socket channel to send the command and read response.
     *        
     * @param command to send
     * @return MPD's response to the command 
     */
    public <R extends Command.Response> R send(final Command command) throws IOException {
        final List<String> result;
        // try-with-resource: opens socket, a a writer toMpd, and a reader fromMpd
        final SocketAddress address = new InetSocketAddress(host, port);
        try (SocketChannel channel = SocketChannel.open()) {

            channel.connect(address);

            final BufferedReader fromMpd = new BufferedReader(Channels.newReader(channel, UTF_8.newDecoder(), -1));

            String connectResponse;
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
        return (R) command.response(result);
    }

    /**
     * @return true if this is the last line of a command's response. 
     */
    private static boolean responseComplete(final String response) {
        return response.startsWith("OK") || response.startsWith("ACK");
    }

}
```

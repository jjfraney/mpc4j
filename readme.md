Java classes representing text commands and responses of the
Media Player Daemon (MPD, https://www.musicpd.org/)
protocol.

This library has no external dependencies.
Java Standard Edition (java se) 8+ runtime is required for applications that use this library.
The programmer's API requires Java Development Kit (jdk) 8+.

This library does not address concerns of thread management or network access.
These concerns are broadly available in innumerable java frameworks, libraries and containers.
A feature or function of this library that blocks its use in any of these
can be considered a design or implementation bug.
 
#Background
MPD is a media player on linux.
It can be controlled remotely and so offers a control protocol.
The protocol is text based.  A client (e.g., the mpc command line utility)
would send UTF-8 encoded text terminated by a newline (i.e., a line)
to the MPD which would respond
with one or more lines of UTF-8 encoded text.
 
#Goals
This library provides classes that represent the commands
and responses of the MPD protocol.
It presents the text-based MPD protocol as Java classes.
Like in Java's JAXB, where Javabeans are mapped to xml text, this library's classes
are mapped to the music player daemons's text commands and response.

Accommodation for change in the MPD protocol is present.
For example:
* response parsing does not fail in presence of unexpected fields (new fields).
* unexpected fields (new fields) can be accessed by later applications.
* command base classes are available for creating new command classes.

The classes are intentionally immutable so they
can be used in environments where immutability is an advantage (e.g., reactive environments).
The classes do not support methods that can change private data.
They do not conform to the JavaBean convention.
The lack of setters is a consequence of the immutability goal and is by design.

This library is not providing a component to drive the
exchange of messages with MPD
(for example, a client side implementation
using a Java IO library).
Such can be obtained from online programming examples.
However, a prototype is provided
to demonstrate how such would use the Command and Responses of this library.
This prototype may be suitable for some environments.
The author encourages developers to implement
the network component appropriate for their
specific runtime environment (i.e. Java SE, JavaEE, Android, vertx, akka, whatever).
 
#Design
For each MPD command, two classes are provided.  One is a Command;
the other is a Response.

The Command could have parameters.
The Command would provide the MPD protocol text-command as a String.

The MPD text-response is parsed by a Response.
The Response would expose getter methods to allow access
of the parameters of the response.

The implementation of the Command and Response are lightly coupled:
The Response is a static nested class of the Command.
The Response is in the Command's namespace.  The Response to
a 'status' command is named 'Status.Response'.
The Command and its Response are implemented, and viewed,
within the same Java class.  For example, the Status.Response class
is nested within the Status command class.

The Command class provides a Response factory method that should be
invoked by the developer provided implementation that receives responses
from MPD.

#Usage

An example usage:

```java
    // to set volume to 10%
    SetVol setVol = new SetVol(10);
    Simple.Response setVolResponse = .....send(setVol);
    boolean success = setVolResponse.isOk();
```
    
Because the Java ecosystem contains multiple client socket programming models,
this library does not provide such implementation
other than a nominally functional prototype.
Developers are encouraged to implement an appropriate send/receive method
for their framework.
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
    public <R extends Command.Response> R send(Command command) throws IOException {
        List<String> result;
        // try-with-resource: opens socket, a a writer toMpd, and a reader fromMpd
        SocketAddress address = new InetSocketAddress(host, port);
        try (SocketChannel channel = SocketChannel.open()) {

            channel.connect(address);

            BufferedReader fromMpd = new BufferedReader(Channels.newReader(channel, UTF_8.newDecoder(), -1));

            String connectResponse;
            // first, expect the connect status
            while ((connectResponse = fromMpd.readLine()) != null) {
                if (responseComplete(connectResponse)) {
                    break;
                }
            }

            // now send the command as text
            ByteBuffer outGoing = ByteBuffer.wrap((command.text() + "\n").getBytes(UTF_8));
            channel.write(outGoing);

            // then read response into a List
            List<String> lines = new ArrayList<>();
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
    private static boolean responseComplete(String response) {
        return response.startsWith("OK") || response.startsWith("ACK");
    }

}
```

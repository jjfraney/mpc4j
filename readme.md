Java classes representing text commands and responses of the
Media Player Daemon (MPD, https://www.musicpd.org/)
protocol.
 
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

The classes are intentionally immutable so they
can be used in environments where immutability is an advantage (e.g., reactive environments).

This library's command and response classes do not conform to the
JavaBean convention.  The lack of setters is a consequence of
the immutability goal.

The author expects the classes can be extended (by sub-classing)
to provide the JavaBean convention (by the sub-classes)
for cases where immutability is not required.
This use is an expected customization of the library.  

This library is not providing a component to drive the
exchange of messages with MPD
(for example, a client side implementation
using a Java IO library).
Such can be easily obtained from onine programming examples.
However, a prototype is provided
to demonstrate how such would use the Command and Responses of this library.
This prototype may be suitable for some environments.
The author encourages developers to implement
the network component appropriate for their
specific runtime environment (i.e. Java SE, JavaEE, vertx, akka, whatever).
 
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

The usage of the Command and Response would be:

```java
    SetVol setVol = new SetVol();
    Simple.Response setVolResponse = .....send(setVol);
    boolean success = setVolResponse.isOk();
```
    
Because the Java ecosystem contains many client socket programming models,
this library does not provide such implementation
other than a nominally functional prototype.
Developers are encouraged to implement an appropriate send/receive method
for their framework.
Such an implementation, perhaps a method named ```send```,
would use the Command and Response this way:

```java
    public <R extends Command.Response> R send(Command<R> command) {
        // set up a socket
        
        // get command text
        String commandText = command.text();
        
        // write to socket with UTF8 encoding
        
        // read from socket, decode with UFT8, into an array: one line per element
        String [] responseLines = ....;
        
        // create response and return
        return (R) command.response(responseLines);
    }
```

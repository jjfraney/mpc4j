A Java library of components that represent text commands and responses of the
Media Player Daemon's protocol.

 
#Background
MPD [(Music Player Daemon)](http://www.musicpd.org) is a media player on linux.
It can be controlled remotely and so offers a control protocol.
The protocol is text based.  A client (e.g., the mpc command line utility)
would send UTF-8 encoded text terminated by a newline (i.e., a line)
to the MPD which would respond
with one or more lines of UTF-8 encoded text.
 
#Goals
This library provides components that represent the commands
and responses of the MPD protocol.
The intent is to provide a programming model like in Java's JAXB,
where Javabeans are mapped to xml text.

This library has no external dependencies.
Java Standard Edition (java se) 8+ runtime is required for applications that use this library.
The programmer's API requires Java Development Kit (jdk) 8+.

This library does not address concerns of thread management or network transport.
These are addressed in innumerable java frameworks, libraries and containers.
This library is compatible with these.
(A prototype socket component is provided
to demonstrate how such would use the Command and Responses of this library.
This prototype may be suited to some requirements.)

The library is resilient to changes in the MPD protocol.
For example:
* response parsing does not fail in presence of unexpected fields (new fields).
* unexpected fields (new fields) can be accessed by later applications, and generic access method are provided.
* new commands can easily be added, and command base classes are available for reuse.
* the library does not implement behavior for the case of an absent field; the library returns an Optional.

The classes are intentionally immutable so they
can be used in environments where immutability is an advantage.
They do not conform to the JavaBean convention.
The lack of setters is a consequence of the immutability goal.

#Design
For each MPD command, two classes are provided.  One is a Command;
the other is a Response.

The Command could have parameters.
The Command would provide the MPD protocol text-command as a String.

The MPD text-based response is parsed by a Response implementation specific to the Command.
The Response would expose getter methods to allow access
of the fields of the response.

The implementation of the Command and its Response are coupled.
In the MPD protocol, command-response exchange is serialized.
Responses arrive in the order the commands were sent.
There is no other correlation for a response to be matched to a command.
This library's Command instance has a factory method for its Response class.
After the response lines are received, the factory method is called to
build the Response instance appropriate for the Command.
The sender can retain the last command sent and assume the next received response matches.

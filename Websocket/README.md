# WebSocket Messaging with Spring Boot
- Run server,
- Run client 1,
- Run client 2

Check the logs seperately, see that the clients invoking the server to send back them a message. <br/>
The server listens messages from _/app/process-message_ where the clients sends requests to.<br/>
The server sends messages to _/topic/messages_ where the clients subscribes to.

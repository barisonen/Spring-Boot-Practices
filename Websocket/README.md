# WebSocket Messaging with Spring Boot
- Run server,
- Run client 1,
- Run client 2

* Check the logs of client one and client two. See that both clients sending and receiving messages via common chat. <br/>
* The server listens messages from _/app/process-message_ where the clients sends requests to.<br/>
* The server sends received messages to _/topic/messages_ where the clients subscribes to.

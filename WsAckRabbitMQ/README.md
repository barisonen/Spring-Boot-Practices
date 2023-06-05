# WS Acknowledgement with RabbitMQ
**POST:** http://localhost:8080/api/send-message <br/>
with body: {
"message": "hello"
} <br/>
<br/>
**Step 1:** Check the logs, and see the message is sent through the publisher to the consumer. <br/>
**Step 2:** Comment MessageSubscriber, and restart <br/>
**Step 3:** Check http://localhost:15672/#/queues/%2F/queue-name <br/>
**Step 4:** Send the message again and click get messages button to see the message there. <br/>
**Step 5:** Uncomment MessageSubscriber and restart. <br/>
**Step 6:** See that after subscriber re-subscribes, it receives the message it missed. thanks to ack mechanism.
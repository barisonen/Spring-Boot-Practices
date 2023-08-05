# Spring State Machine

In this very good software company, <br/>
There are 2 stages of code approval process. <br/><br/>
Scenarios are as follows: <br/><br/>
Colleague rejeced -> **REJECTED** <br/>
Colleague approved -> Team Leader rejected -> **REJECTED** <br/>
Colleague approved ->  Team Leader approved -> **APPROVED** <br/>

Also the Colleague is a bit silly, who sometimes forget to sign their approval with the secret company
signature. <br/> <br/>
In that case the Team Leader sees that the Colleague is appeared to have approved the process so that now its Team
Leader's time
to approve, however the Team Leader cannot validate the secret signature. <br/><br/>
Thanks to Guard, the process is being blocked if this occurs and the admin needs to reset it. <br/><br/>
The correctness of signature is random, <br/><br/>
**GET:** http://localhost:8080/api/process and check the logs. <br/><br/>
If signature is not validated try again, <br/><br/>
**GET:** http://localhost:8080/api/reset and<br/>
**GET:** http://localhost:8080/api/process repeat this process until you are lucky enough that you had the 1/2 chance to
get
the signature correct. <br/><br/>
You can also see the events and the state transitions in the logs. 

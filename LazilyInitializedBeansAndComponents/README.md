# Lazy Initialization of Beans & Components

Example of Lazy Initialization of Beans & Components. <br/>
**Lazy bean:** LazyCar <br/>
**Lazy Service:** SomeLazyService <br/>
**Other bean:** Ship <br/>
**Other service which calls the lazy service:** SomeService <br/>

_Run the project & check the logs._ <br/>

<img width="1051" alt="Screenshot 2023-06-27 at 21 13 48" src="https://github.com/barisonen/Spring-Boot-Practices/assets/43679838/bee316d7-899b-4e43-96ca-6e928fee7755">
<br/>
See that SomeService and Ship initialized when spring starts while SomeLazyService and LazyCar initialized only when needed.

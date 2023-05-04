# Spring Boot Transactions
**JPA** <br/><br/>
_Note: you can import the postman collection under the root of the project._ 
- **Transaction scenario 1: <br/>**
@Transactional Method:
Without any save operation, entity changes automatically reflected to the database
after the transaction ends. <br/><br/>
- **Transaction scenario 2-1: <br/>**
  After successful first save, second save will throw DataIntegrityException because
  we are violating the unique constraint of name field in car table. However, first save
  will remain. <br/><br/>
- **Transaction scenario 2-2:**
  With transaction, first save will be rolled back when exception occurs
  in the second one.
# Spring Data JPA Transactions

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
  in the second one. <br/><br/>

- **Scenario 3-1:**
  See a transactional method calls another transactional method
  with the propagation of REQUIRED.
  Check the logs that in both methods the transaction is the same
  and exception in the second method rollbacks the first change. <br/><br/>

- **Scenario 3-2:**
  See a transactional method calls another transactional method 
  with the propagation of REQUIRES_NEW.
  Check the logs that both methods have different transactions.
  However, exception in the second method also rollbacks the first change. <br/><br/>

- **Scenario 3-3:**
  A non-transactional method calls a transactional method with
  the propagation of REQUIRES_NEW. In the transaction there are 2 save operations,
  which the second save throws an exception and the first save, 
  which is inside the second method's transaction scope, is rollbacked.
  However, the save operation in the first method persists.
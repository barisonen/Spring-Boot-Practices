# N + 1 Query Problem
Configured fetch type LAZY of a relationship of 2 entities. <br/> 
Fetched all parent entities and in a loop fetched their children. <br/><br/>
**GET:** http://localhost:8080/find-all <br/>
If you inspect the logs, after findAll statement's query, there is additional 
query for each parent to fetch its children. <br/> <br/>

Configured fetch type EAGER, same query amount have been executed, but at the 
time of findAll, not seperately inside loop. So this didnt reduce the query amount as well.<br/><br/>
Lastly, written jpql to overcome this issue: <br/><br/>
_@Query("SELECT o FROM Owner o LEFT JOIN FETCH o.cars") <br/>
List<Owner> findAllWithOneQuery();_<br/><br/>
**GET:** http://localhost:8080/find-all-with-one-query <br/>
inspect the logs and see that one query has been executed.

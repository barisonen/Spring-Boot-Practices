# Caching with Redis
<br/><br/>
_General Idea belongs to Shubham from DigitalOcean. I created, worked, enhanced the project._
<br/><br/>

This project is about a social media where users with more than 10000 followers are cached because they are likely to be searched more often. <br/>
<br/>

**Run redis from docker:** docker run --name cache-with-redis -p 6379:6379 -d redis <br/>
After running the project, 2 default users created in H2 database with 1 & 2. <br/>

Send the 2 below requests several times <br/>
**GET:** http://localhost:8080/user/1 <br/>
**GET:** http://localhost:8080/user/2 <br/><br/>
If you check the logs, you will see that the user (id 2) with more than 10000 followers is cached and **Getting user with ID 2** is logged just once. <br/>
However the first user is not cached and **Getting user with ID 1** is logged every time you query. <br/>
 

**Update user 1 to be cached:** <br/>
**PUT:** http://localhost:8080/user/update <br/>
with body: <br/>
{ <br/>
    "id": 1, <br/>
    "name": "baris", <br/>
    "followers": 15000 <br/>
} <br/>

After this request user 1 is also cached. <br/>

**Clear the cache:** <br/>
**DELETE:** http://localhost:8080/user/1 (deletes the user with id 1, also clears the cache)

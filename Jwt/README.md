**In MySQL db, create User table and insert following:** <br/><br/>
username: randomuser1 <br/>
password: $2a$10$xS239BLyn6JSkwmQiWwxZubk9dzrH5IWqfARY8wcpeFX5Y.acfvqi

send post request to /login with body:

{ <br/>
&ensp;    "username":"randomuser1", <br/>
&ensp;    "password":"password" <br/>
}


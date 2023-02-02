# Jwt Auth System <br/><br/>
Enter your my sql db credentials and a 512 bit base 64 secret key to run configurations.<br/><br/>
Try and fail to see the secured content: <br/>
**GET:** http://localhost:8080/secured-controller/access <br/><br/>
**Signup:**<br/>
**POST:** http://localhost:8080/auth/signUp <br/>
with a body like: <br/>
{ <br/>
&emsp;"firstName": "Baris", <br/>
&emsp;"lastName": "Onen", <br/>
&emsp;"email": "barisonen1996@icloud.com", <br/>
&emsp;"password": "1234" <br/>
} <br/> <br/>
_copy the token_ <br/><br/>
See the secured content: <br/>
Paste the token in header (Authorization: Bearer _**token**_)<br/>
**GET:** http://localhost:8080/secured-controller/access <br/><br/>
**Signin:**<br/>
**POST:** http://localhost:8080/auth/signIn <br/>
with a body like: <br/>
{ <br/>
&emsp;"email": "barisonen1996@icloud.com", <br/>
&emsp;"password": "1234" <br/>
} <br/><br/>
_copy the token_ <br/><br/>
See the secured content: <br/>
Paste the token in header (Authorization: Bearer _**token**_)<br/>
**GET:** http://localhost:8080/secured-controller/access <br/><br/>


# Spring Security with JWT and Database <br/>
In addition to your mysql db credentials, <br/>add a 512 bit base 64 secret key through environment variables <br/> or just type _dRgUkXp2s5dooaxAqscpoaxmcAKASsqiasiASQsvnhAHqjwfjsabrrv8yADGKbPeShVmYq3t6w9zCEHMcQfTjWnZr4u7xADG_ <br/><br/>
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

**Authorization**<br/>
See that you cannot access admin data:<br/>
**GET:** http://localhost:8080/secured-controller/admin <br/><br/>
Make yourself an admin: <br/>
**GET:** http://localhost:8080/secured-controller/makeMeAdmin <br/><br/>
Check again: <br/>
**GET:** http://localhost:8080/secured-controller/admin <br/><br/>




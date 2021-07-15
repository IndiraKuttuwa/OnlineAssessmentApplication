<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@taglib uri= "http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>


<html>	
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Online Assessment - Home Page</title>
</head>
<body style="background-color: #00FFFF;">
<h1>Welcome to Online Assessments</h1>
<br>
<br>
<h2>Login</h2>
<br>
<br>
<br>
<br>
<form action="login/do" method="post">
<label for="email">Email ID:</label>
<input type="email" id="email" name="email" required> 
<br>
<br>
<label for="password">Password</label>
<input type="password" id="password" name="password" required>
<br>
<br>
<input type="submit" id="login" value="LOGIN">
<br>
<br>
<br>

</form>

<div id="newUser">
New User ? <a id="register" href='<s:url value="/registration.html"></s:url>'>register here</a>
</div>

</body>
</html>
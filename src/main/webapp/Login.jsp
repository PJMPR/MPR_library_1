<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginServlet" method="get">
		<label>Login: <input type="text" id="login" name="login"></label><br/>
		<label>Password: <input type="text" id="password" name="password"></label><br/>
		<button type="submit">Login</button>	

	</form>
	<form action="/addUser.html">
		<button type="submit">Register</button>	
		</form>	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="AuthorServlet" method="get">
		<label>FirstName: <input type="text" id="firstname" name="firstname"></label>
		<label>LastName: <input type="text" id="lastname" name="lastname"></label>
		<br/>
		
		<button type="submit">send</button>
	    </form>
</body>
</html>
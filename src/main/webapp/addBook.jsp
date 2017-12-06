<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Book</title>
</head>
<body>
	<form action="Book" method="POST">
		<label>title: <input type="text" id="title" name="title"></label><br/>
		<label>publisher: <input type="text" id="publisher" name="publisher"></label><br/>
		<label>year: <input type="text" id="year" name="year"></label><br/>
		
		<button type="submit">Add book</button>
	</form>
</body>
</html>
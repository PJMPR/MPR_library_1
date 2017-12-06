<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Address" method="get">
		<label>Street: <input type="text" id="street" name="street"></label><br/>
		<label>City: <input type="text" id="city" name="city"></label><br/>
		<label>Post Code: <input type="text" id="postcode" name="postcode"></label><br/>
		<label>Country: <input type="text" id="country" name="country"></label><br/>
		<label>House number: <input type="text" id="housenumber" name="housenumber"></label><br/>
		<label>Local number: <input type="text" id="localnumber" name="localnumber"></label><br/>
		<label>Phone: <input type="text" id="phone" name="phone"></label><br/>
		<button type="submit">send</button>
	</form>
</body>

</html>
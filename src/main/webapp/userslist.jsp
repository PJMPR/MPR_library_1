<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="library.dao.repos.*" %>
<%@ page import="library.dao.repos.impl.*" %>
<%@ page import="library.domain.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
	<%
	IDatabaseCatalog library = new HsqlDbCatalogFactory().library();
	for(User u: library.users().getPage(1, 10)){%>
		<li><%=u.getLogin()%></li>		
	<% 
	}
	%>
</ul>
</body>
</html>
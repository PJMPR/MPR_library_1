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
	int numberPage=Integer.valueOf(request.getParameter("numberPage"));
	IDatabaseCatalog library = new HsqlDbCatalogFactory().library();
	for(User u: library.users().getPage(numberPage, 2)){%>
		<li><%=u.getLogin()%></li>		
	<%
	}
	%>
</ul>

	<a href="/userslist.jsp?numberPage=<%=++numberPage%>">Next</a>	

</body>
</html>
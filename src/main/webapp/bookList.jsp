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
	<table border="1">
	<tr><th>Title</th><th></th></tr>
	<%
	int number = 0;
	int pageNumber = Integer.parseInt(request.getParameter("page"));
	if (String.valueOf(pageNumber) == null)
	{	
		pageNumber = 1;
		number = 2;
	}
	else
	{
		number = pageNumber + 1;
	}
	IDatabaseCatalog library = new HsqlDbCatalogFactory().library();
	for(Book b: library.books().getPage(pageNumber, 10)){%>
		<tr><td><%=b.getTitle()%></td><td>Zarezerwuj</td></tr>
	<%
	}
	%>
	</table>
	<button><a href="bookList.jsp?page=<%=number%>">Next</a></button>
</body>
</html>
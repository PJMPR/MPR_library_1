<%@page import="java.util.*"%>
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
	List<Book> booksForsession = new ArrayList<Book>();
	booksForsession.addAll(library.books().getPage( 1, 10));
	session.setAttribute("reservedBooks", booksForsession);
	
	List<Book> booksFromSession = (List<Book>) session.getAttribute("reservedBooks");
	for(Book b: booksForsession){%>
		<td>ID: <%=b.getId()%></td>
		<td>Title: <%=b.getTitle()%></td>
		<td>Publisher: <%=b.getPublisher() %></td>
		<td>Year: <%=b.getYear()%></td><button type="delete"<%=booksForsession.remove(b.getId())%>>usun</button><br>	
	<% 
	}
	%>
	
	
	
	
	
</ul>
</body>
</html>
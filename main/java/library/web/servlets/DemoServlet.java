package library.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.dao.repos.IDatabaseCatalog;
import library.dao.repos.impl.HsqlDbCatalogFactory;

@WebServlet("/Demo")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DemoServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		
		IDatabaseCatalog library = new HsqlDbCatalogFactory().library();
		
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		if(name!=null && !name.isEmpty())
			out.println("Hello " + name);
		
		out.println("Hello World From Servlet");
		
	}
	
}

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
import library.domain.Author;
import library.domain.User;

@WebServlet("/AuthorServlet")
public class AuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AuthorServlet() {
    	super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    
    	IDatabaseCatalog library = new HsqlDbCatalogFactory().library();
		PrintWriter out = response.getWriter();
		
	
		String FirstName = request.getParameter("firstname");
		String LastName = request.getParameter("lastname");

		
		if(FirstName!=null && !FirstName.isEmpty())
			out.println("Hello " + FirstName);
		
		if(LastName!=null && !LastName.isEmpty())
			out.println("your e-mail :" + LastName);
		
		Author author = new Author();
    	author.setFirstName(FirstName);
    	author.setLastName(LastName);

    	
    	library.authors().add(author);
    	
    
		
		  library.saveChanges();
		
	}

}

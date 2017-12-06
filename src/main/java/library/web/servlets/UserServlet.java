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
import library.domain.User;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		IDatabaseCatalog library = new HsqlDbCatalogFactory().library();
		
		
		PrintWriter out = response.getWriter();
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		if(login!=null && !login.isEmpty())
			out.println("Hello " + login);
		
		if(password.isEmpty())
			out.println("Enter the password please!");
		
		if(email!=null && !email.isEmpty())
			out.println("your e-mail :" + email);
		
		User user = new User();
    	user.setEmail(email);
    	user.setLogin(login);
    	user.setPassword(password);
    	
    	library.users().add(user);
    	
    
		
		  library.saveChanges();
		
	}

}

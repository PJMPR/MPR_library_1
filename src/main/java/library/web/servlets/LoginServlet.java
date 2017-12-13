package library.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.dao.repos.IDatabaseCatalog;
import library.dao.repos.impl.HsqlDbCatalogFactory;
import library.domain.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		
		IDatabaseCatalog library = new HsqlDbCatalogFactory().library();
		
		PrintWriter out = response.getWriter();
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		if(password.isEmpty()){
			out.println("Enter the password please!");
		}
		else if(login!=null && !login.isEmpty())
		{
			List<User>listUser= new ArrayList<>();
			listUser=library.users().withLogin(login);
			if(listUser.isEmpty())
			{
				out.println("Bad login.");
				
			}else
			{
				User u = new User();
				u=listUser.get(0);
				if(u.getPassword().equals(password)){
					response.sendRedirect("/index.html");
				}else{
					out.println("Bad password.");
					
				}
			}
		}

		
	
	}
	
}

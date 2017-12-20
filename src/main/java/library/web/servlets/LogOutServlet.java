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
import library.web.SessionConstants;

@WebServlet("/LogOutServlet")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LogOutServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
			request.getSession().setAttribute(SessionConstants.LoggedUser, null);
			response.sendRedirect("/Login.jsp");
	
	}
	
}

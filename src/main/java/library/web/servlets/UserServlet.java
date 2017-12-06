package library.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.dao.repos.IDatabaseCatalog;
import library.dao.repos.impl.DatabaseCatalog;
import library.dao.repos.impl.HsqlDbCatalogFactory;
import library.dao.uow.IUnitOfWork;
import library.dao.uow.UnitOfWork;
import library.domain.User;


@WebServlet("/User")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		User user= new User();
		user.setLogin(request.getParameter("login"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		IDatabaseCatalog library = new HsqlDbCatalogFactory().library();
		library.users().add(user);
	}

}

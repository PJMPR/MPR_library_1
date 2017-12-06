package library.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.dao.repos.IDatabaseCatalog;
import library.dao.repos.impl.DatabaseCatalog;
import library.dao.uow.IUnitOfWork;
import library.dao.uow.UnitOfWork;
import library.domain.Person;
import library.domain.User;


@WebServlet("/PersonServlet")
public class PersonServlet {
	private static final long serialVersionUID = 1L;

    public PersonServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException {
		

    	String url = "jdbc:hsqldb:hsql://localhost/workdb";
    	
    	Connection connection = DriverManager.getConnection(url);
    	IUnitOfWork uow = new UnitOfWork(connection);
    	
    	IDatabaseCatalog catalog = new DatabaseCatalog(connection, uow);
		
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		
		if(name!=null && !name.isEmpty())
			out.println("Hi" + name);
		
		if (!surname.isEmpty())
				out.println("Proszę podac nazwisko");
		
		
    	Person jan = new Person();
    	jan.setName(name);
    	jan.setSurname(surname);
    	catalog.people().add(jan);
    	
    	
    uow.saveChanges();
    connection.close();
	}

}

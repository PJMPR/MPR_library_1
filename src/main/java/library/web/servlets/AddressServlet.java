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
import library.domain.Address;

@WebServlet("/Address")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddressServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Address address= new Address();
		address.setCity(request.getParameter("city"));
		address.setCountry(request.getParameter("country"));
		address.setHouseNumber(request.getParameter("housenumber"));
		address.setLocalNumber(request.getParameter("localnumber"));
		address.setPhone(request.getParameter("phone"));
		address.setPostCode(request.getParameter("postcode"));
		address.setStreet(request.getParameter("street"));
		IDatabaseCatalog library = new HsqlDbCatalogFactory().library();
		library.addresses().add(address);
		library.saveChanges();
		
		
		
	}

}

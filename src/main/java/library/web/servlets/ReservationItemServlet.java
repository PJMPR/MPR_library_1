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
import library.domain.ReservationItem;

@WebServlet("/ReservationItemServlet")
public class ReservationItemServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

    public ReservationItemServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		IDatabaseCatalog library = new HsqlDbCatalogFactory().library();
		ReservationItem reservationItem = new ReservationItem();
		
		
		PrintWriter out = response.getWriter();
		String reservationId = request.getParameter("reservationId");
		String bookId = request.getParameter("bookId");
		
		int n1 = Integer.parseInt(bookId);
		int n2 = Integer.parseInt(reservationId);
		
		reservationItem.setBookId(n1);
		reservationItem.setReservationId(n2);
		
		if(reservationId!=null && !reservationId.isEmpty())
			out.println("Rezerwacja " + reservationId);
		
		if(bookId!=null && !reservationId.isEmpty())
			out.println("Ksiazka " + bookId);
		
		library.reservationItems().add(reservationItem);
		library.saveChanges();
		out.println("Hello World From Servlet");
	}
}

package library.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReservationItemServlet")
public class ReservationItemServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

    public ReservationItemServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String reservationId = request.getParameter("reservationId");
		String bookId = request.getParameter("bookId");
		if(reservationId!=null && !reservationId.isEmpty())
			out.println("Rezerwacja " + reservationId);
		
		if(bookId!=null && !reservationId.isEmpty())
			out.println("Ksiazka " + bookId);
		
		out.println("Hello World From Servlet");
	}
}

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
import library.domain.Book;

@WebServlet("/Book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String publisher = request.getParameter("publisher");
		int year = Integer.valueOf(request.getParameter("year"));
		boolean isAvailable = true;
		
		PrintWriter out = response.getWriter();
		
		if(title!=null && !title.isEmpty() && publisher!=null && !publisher.isEmpty() && String.valueOf(year)!=null && !String.valueOf(year).isEmpty())
		{
			IDatabaseCatalog library = new HsqlDbCatalogFactory().library();
		    	
		    Book book = new Book();
		    book.setTitle(title);
		    book.setPublisher(publisher);
		    book.setYear(year);
		    book.setisAvailable(isAvailable);
		    
		    library.books().add(book);
		    library.saveChanges();
		    
		    out.println("Title: " + book.getTitle());
		    out.println("Publisher: " + book.getPublisher());
		    out.println("Year: " + book.getYear());
		    out.println("Available: " + book.isAvailable());

			out.println("Added book to db");
		}
	}
}

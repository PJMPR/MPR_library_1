package library.daor.repos.examples;

import java.sql.Connection;
import java.util.List;

import library.dao.repos.IDatabaseCatalog;
import library.domain.Book;

public class BookRepositoryExample {
	
	public static void run(Connection connection,IDatabaseCatalog catalog){
		
		catalog.books().createTable();
    	
    	Book book = new Book();
    	book.setTitle("AAAA");
    	book.setPublisher("BBB");
    	book.setYear(1996);
    	book.setisAvailable(true);
    	
    	catalog.books().add(book);
    	
    	int lastId = catalog.books().lastId();
    	int count = catalog.books().count();
    	
    	List<Book> booksWithTitle = catalog.books().withTitle("Titile");
    	List<Book> booksWithPublisher = catalog.books().withPublisher("Publisher");
    	List<Book> booksWithAvailability = catalog.books().withAvailability(true);
    	
    	System.out.println(lastId + " " +  count);
	}

}

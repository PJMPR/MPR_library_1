package library.daor.repos.examples;

import java.sql.Connection;

import library.dao.mappers.BookMapper;
import library.dao.repos.IDatabaseCatalog;
import library.dao.repos.impl.BookRepository;
import library.domain.Author;
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
    	
    	System.out.println(lastId + " " +  count);
	}

}

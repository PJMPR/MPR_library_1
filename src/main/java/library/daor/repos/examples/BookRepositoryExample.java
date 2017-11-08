package library.daor.repos.examples;

import java.sql.Connection;

import library.dao.repos.BookRepository;

public class BookRepositoryExample {
	
	public static void run(Connection connection){
		
		BookRepository bookRepository = new BookRepository(connection);
    	bookRepository.createTable();
		
	}

}

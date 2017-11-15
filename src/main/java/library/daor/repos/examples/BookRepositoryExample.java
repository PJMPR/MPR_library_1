package library.daor.repos.examples;

import java.sql.Connection;

import library.dao.mappers.BookMapper;
import library.dao.repos.impl.BookRepository;

public class BookRepositoryExample {
	
	public static void run(Connection connection){
		
		BookRepository bookRepository = new BookRepository(connection, new BookMapper());
    	bookRepository.createTable();
		
	}

}

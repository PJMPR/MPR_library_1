package library.daor.repos.examples;

import java.sql.Connection;

import library.dao.repos.AuthorRepository;
import library.domain.Author;


public class AuthorRepositoryExample {
	public static void run(Connection connection){
		
    	AuthorRepository repository = new AuthorRepository(connection);
    	repository.createTable();
    	
    	Author author = new Author();
    	author.setFirst_name("Pawel");
    	author.setLast_name("Nowak");
    	
    	repository.add(author);
    	
    	int lastId = repository.lastId();
    	int count = repository.count();
    	
    	System.out.println(lastId + " " +  count);
		
	}

}

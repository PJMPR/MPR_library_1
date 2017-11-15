package library.daor.repos.examples;

import java.sql.Connection;

import library.dao.mappers.AuthorMapper;
import library.dao.repos.IDatabaseCatalog;
import library.dao.repos.impl.AuthorRepository;
import library.domain.Author;


public class AuthorRepositoryExample {
	public static void run(Connection connection,IDatabaseCatalog catalog){
		
    	catalog.authors().createTable();
    	
    	Author author = new Author();
    	author.setFirstName("Pawel");
    	author.setLastName("Nowak");
    	
    	catalog.authors().add(author);
    	
    	int lastId = catalog.authors().lastId();
    	int count = catalog.authors().count();
    	
    	System.out.println(lastId + " " +  count);
		
	}

}

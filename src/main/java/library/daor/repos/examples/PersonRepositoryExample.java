package library.daor.repos.examples;

import java.sql.Connection;

import library.dao.mappers.PersonMapper;
import library.dao.repos.IDatabaseCatalog;
import library.dao.repos.IRepository;
import library.dao.repos.impl.PersonRepository;
import library.domain.Person;

public class PersonRepositoryExample {

	public static void run(Connection connection, IDatabaseCatalog catalog){
		
		
    	catalog.people().createTable();
    	
    	Person jan = new Person();
    	jan.setName("JAN");
    	jan.setSurname("kowalski");
    	
    	catalog.people().add(jan);
    	
    	int lastId = catalog.people().lastId();
    	int count = catalog.people().count();
    	
    	System.out.println(lastId + " " +  count);
		
	}
	
}

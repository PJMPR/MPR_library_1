package library.daor.repos.examples;

import java.sql.Connection;

import library.dao.repos.PersonRepository;
import library.domain.Person;

public class PersonRepositoryExample {

	public static void run(Connection connection){
		
    	PersonRepository repository = new PersonRepository(connection);
    	repository.createTable();
    	
    	Person jan = new Person();
    	jan.setName("JAN");
    	jan.setSurname("kowalski");
    	
    	repository.add(jan);
    	
    	int lastId = repository.lastId();
    	int count = repository.count();
    	
    	System.out.println(lastId + " " +  count);
		
	}
	
}

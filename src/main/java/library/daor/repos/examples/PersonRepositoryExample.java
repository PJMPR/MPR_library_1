package library.daor.repos.examples;

import java.sql.Connection;
import java.util.List;

import library.dao.repos.IDatabaseCatalog;
import library.dao.uow.IUnitOfWork;
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
    	
    	List<Person> janki = catalog.people().withName("jan");
    	
    	System.out.println(lastId + " " +  count);
		
	}
	
}

package library.daor.repos.examples;
import java.sql.Connection;

import library.dao.repos.IDatabaseCatalog;
import library.domain.User;

public class UserRepositoryExample {

	public static void run(Connection connection, IDatabaseCatalog catalog){
		
    	catalog.users().createTable();
    	
    	User jan = new User();
    	jan.setId(1);
    	jan.setEmail("user@example.com");
    	jan.setLogin("Janusz");
    	jan.setPassword("janusz011");
    	
    	catalog.users().add(jan);
    	
    	int lastId = catalog.users().lastId();
    	int count = catalog.users().count();
    	
    	System.out.println(lastId + " " +  count);
		
	}
	
}

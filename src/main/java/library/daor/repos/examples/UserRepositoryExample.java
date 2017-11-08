package library.daor.repos.examples;
import java.sql.Connection;
import library.dao.repos.UserRepository;
import library.domain.User;

public class UserRepositoryExample {

	public static void run(Connection connection){
		
    	UserRepository repository = new UserRepository(connection);
    	repository.createTable();
    	
    	User jan = new User();
    	jan.setId(1);
    	jan.setEmail("user@example.com");
    	jan.setLogin("Janusz");
    	jan.setPassword("janusz011");
    	
    	repository.add(jan);
    	
    	int lastId = repository.lastId();
    	int count = repository.count();
    	
    	System.out.println(lastId + " " +  count);
		
	}
	
}

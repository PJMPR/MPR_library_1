package library.dao.repos;


import java.util.List;
import library.domain.User;


public interface IUserRepository extends IRepository<User>{

	List<User> withLogin(String login);
	List<User> withEmail(String email);
	
}

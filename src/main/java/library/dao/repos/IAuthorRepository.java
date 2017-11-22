package library.dao.repos;

import java.util.List;

import library.domain.Author;
import library.domain.Person;

public interface IAuthorRepository extends IRepository<Author> {
	
	public List<Author> withFirstName(String name);
	public List<Author> withLastname(String surname);
	
}

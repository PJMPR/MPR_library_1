package library.dao.repos;

import library.domain.Address;
import library.domain.Author;
import library.domain.Person;

public interface IDatabaseCatalog {

	public IRepository<Address> addresses();
	public IRepository<Person> people();
	public IRepository<Author> authors();
	
}

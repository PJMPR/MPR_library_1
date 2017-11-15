package library.dao.repos;

import library.domain.Address;
import library.domain.Author;
import library.domain.Book;
import library.domain.Person;
import library.domain.User;

public interface IDatabaseCatalog {

	public IRepository<Address> addresses();
	public IRepository<Person> people();
	public IRepository<Author> authors();
	public IRepository<Book> books();
	public IRepository<User> users();
}

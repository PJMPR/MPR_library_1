package library.dao.repos;

import java.util.List;

import library.domain.Person;

public interface IPersonRepository extends IRepository<Person> {

	public List<Person> withName(String name);
	public List<Person> withSurname(String surname);
	
}

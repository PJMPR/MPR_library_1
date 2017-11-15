package library.dao.repos.impl;

import java.sql.Connection;
import java.sql.SQLException;

import library.dao.mappers.PersonMapper;
import library.dao.repos.IDatabaseCatalog;
import library.dao.repos.IRepository;
import library.domain.Address;
import library.domain.Author;
import library.domain.Person;

public class DatabaseCatalog implements IDatabaseCatalog{

	Connection connection;
	
	public DatabaseCatalog(Connection connection){
		this.connection = connection;
	}
	
	@Override
	public IRepository<Address> addresses() {
		return null;
	}

	@Override
	public IRepository<Person> people() {
		try {
			return new PersonRepository(connection, new PersonMapper());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public IRepository<Author> authors() {
		// TODO Auto-generated method stub
		return null;
	}

}

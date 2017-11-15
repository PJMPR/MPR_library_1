package library.dao.repos.impl;

import java.sql.Connection;
import java.sql.SQLException;

import library.dao.mappers.AddressMapper;
import library.dao.mappers.AuthorMapper;
import library.dao.mappers.BookMapper;
import library.dao.mappers.PersonMapper;
import library.dao.repos.IDatabaseCatalog;
import library.dao.repos.IRepository;
import library.domain.Address;
import library.domain.Author;
import library.domain.Book;
import library.domain.Person;

public class DatabaseCatalog implements IDatabaseCatalog{

	Connection connection;
	
	public DatabaseCatalog(Connection connection){
		this.connection = connection;
	}
	
	@Override
	public IRepository<Address> addresses() {
		try {
			return new AddressRepository(connection, new AddressMapper());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
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
		try {
			return new AuthorRepository(connection, new AuthorMapper());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public IRepository<Book> books() {
		try {
			return new BookRepository(connection, new BookMapper());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}

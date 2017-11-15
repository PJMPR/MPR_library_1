package library.dao.repos.impl;

import java.sql.Connection;
import java.sql.SQLException;

import library.dao.mappers.AddressMapper;
import library.dao.mappers.AuthorMapper;
import library.dao.mappers.BookMapper;
import library.dao.mappers.PersonMapper;
import library.dao.mappers.UserMapper;
import library.dao.repos.IBookRepository;
import library.dao.repos.IDatabaseCatalog;
import library.dao.repos.IPersonRepository;
import library.dao.repos.IRepository;
import library.domain.Address;
import library.domain.Author;
import library.domain.Reservation;
import library.domain.ReservationItem;
import library.domain.User;

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
	public IPersonRepository people() {
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
	public IBookRepository books() {
		try {
			return new BookRepository(connection, new BookMapper());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public IRepository<ReservationItem> reservationItems(){	
		return null;
	}
	
	@Override
	public IRepository<Reservation> reservation(){
		return null;
	}
	

	@Override
	public IRepository<User> users() {
		try {
			return new UserRepository(connection, new UserMapper());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}

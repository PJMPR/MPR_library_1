package library.dao.repos.impl;

import java.sql.Connection;
import java.sql.SQLException;

import library.dao.mappers.AddressMapper;
import library.dao.mappers.AuthorMapper;
import library.dao.mappers.BookMapper;
import library.dao.mappers.PersonMapper;
import library.dao.mappers.ReservationItemMapper;
import library.dao.mappers.ReservationMapper;
import library.dao.mappers.UserMapper;
import library.dao.repos.IBookRepository;
import library.dao.repos.IAuthorRepository;
import library.dao.repos.IAddressRepository;
import library.dao.repos.IDatabaseCatalog;
import library.dao.repos.IPersonRepository;
import library.dao.repos.IRepository;
import library.dao.repos.IReservationRepository;
import library.dao.repos.IUserRepository;
import library.dao.uow.IUnitOfWork;
import library.dao.uow.UnitOfWork;
import library.domain.Address;
import library.domain.Author;
import library.domain.Reservation;
import library.domain.ReservationItem;
import library.domain.User;

public class DatabaseCatalog implements IDatabaseCatalog{

	Connection connection;
	IUnitOfWork uow;
	
	public DatabaseCatalog(Connection connection, IUnitOfWork uow){
		this.connection = connection;
		this.uow = uow;
	}
	
	@Override
	public IAddressRepository addresses() {
		try {
			return new AddressRepository(connection, new AddressMapper(), uow);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public IPersonRepository people() {
		try {
			return new PersonRepository(connection, new PersonMapper(), uow);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public IAuthorRepository authors() {
		try {
			return new AuthorRepository(connection, new AuthorMapper(), uow);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public IBookRepository books() {
		try {
			return new BookRepository(connection, new BookMapper(), uow);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public IRepository<ReservationItem> reservationItems(){	
		try {
			return new ReservationItemRepository(connection, new ReservationItemMapper(), uow);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public IReservationRepository reservation(){
		try {
			return new ReservationRepository(connection, new ReservationMapper(), uow);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	

	@Override
	public IUserRepository users() {
		try {
			return new UserRepository(connection, new UserMapper(), uow);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void saveChanges() {
		uow.saveChanges();
	}

}

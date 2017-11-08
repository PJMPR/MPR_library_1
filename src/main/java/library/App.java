package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import library.dao.repos.AuthorRepository;
import library.dao.repos.BookRepository;
import library.dao.repos.AddressRepository;
import library.dao.repos.PersonRepository;
import library.dao.repos.ReservationItemRepository;
import library.dao.repos.ReservationRepository;
import library.dao.repos.UserRepository;
import library.domain.Address;
import library.domain.Author;
import library.domain.Book;
import library.domain.Person;
import library.domain.Reservation;
import library.domain.ReservationItem;
import library.domain.User;

public class App 
{
    public static void main( String[] args ) throws SQLException
    {

    	String url = "jdbc:hsqldb:hsql://localhost/workdb";
    	
    	Connection connection = DriverManager.getConnection(url);
    	
    	PersonRepository repository = new PersonRepository(connection);
    	repository.createTable();
    	
    	Person jan = new Person();
    	jan.setName("JAN");
    	jan.setSurname("kowalski");
    	
    	repository.add(jan);
    	
    	int lastId = repository.lastId();
    	int count = repository.count();
    	
    	System.out.println(lastId + " " +  count);
    	
    	
    	ReservationRepository reservationRepository = new ReservationRepository();
    	reservationRepository.createTable();
    	
    	Reservation reserv = new Reservation();
    	reserv.setReservationDate(null);
    	reserv.setRetirvalDate(null);
    	reserv.setRealDate(null);
    	
    	reservationRepository.add(reserv);
    	
    	ReservationItemRepository reservationItemRepository = new ReservationItemRepository();
    	reservationItemRepository.createTable();
    	
    	
    	BookRepository bookRepository = new BookRepository(connection);
    	bookRepository.createTable();
    	
    	AuthorRepository authorRepository = new AuthorRepository(connection);
    	authorRepository.createTable();
    	
    	AddressRepository addressRepository = new AddressRepository(connection);
    	addressRepository.createTable();
    	
    	Address address = new Address();
    	address.setStreet("ABC");
    	address.setPostCode("CDF");
    	address.setPhone("123-456-789");
    	address.setLocalNumber("678");
    	address.setCountry("ASGAS");
    	address.setHouseNumber("346");
    	address.setCity("adgasdg");
    	
    	addressRepository.add(address);
    	
    	
    	System.out.println(lastId + " " + count);
    	
    	UserRepository repositoryUser = new UserRepository(connection);
    	repository.createTable();
    	System.out.println(jan.getName() + " " + jan.getSurname()+" " +jan.getId());
        System.out.println( "koniec" );
        
        connection.close();
    }
}
